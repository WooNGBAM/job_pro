package com.example.job_project.Service;

import com.example.job_project.dao.MarketRepository;
import com.example.job_project.entity.Business;
import com.example.job_project.entity.Market;
import com.example.job_project.entity.SimpleList;
import com.example.job_project.entity.SpecList;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/market")
public class MarketController {

    private MarketRepository repository;

    public MarketController(MarketRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/holi")//휴무일 등록
    public void postMarketHoliday(@RequestBody Market holiday){
        System.out.println(holiday.getHolidays().getClass());
        SimpleDateFormat dataParser = new SimpleDateFormat("yyyy-MM-dd");
        for (Date day : holiday.getHolidays())
        {
            repository.saveHoli(holiday.getId(), dataParser.format(day));
            System.out.println(dataParser.format(day).getClass());
        }

    }
    @PostMapping//점포등록
    public Market postMarket(@RequestBody(required = false) Market marketT){

        return repository.save(marketT);
    }

    @DeleteMapping//점포삭제
    public String deleteMarket(int id){
        repository.deleteById(id);
        String tmpTxt = "id : ";
        String tmpId = Integer.toString(id);
        return tmpTxt + tmpId;
    }
    @GetMapping("/testttt")
    public List<Market> getMarketLevel(){//레벨 오름차순 정렬
        return (List<Market>) repository.findAllByOrderByLevelAsc();
    }



    @GetMapping("/search")//간략화 할것/ for문 size()대신 객체사용(코짜님 조언)/return
    public List<SimpleList> getMarketSimple() throws ParseException {

        List<SimpleList> simpleLists = new ArrayList<SimpleList>();
        Date today = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(repository.findById(1).get());
        int size = repository.findAllByOrderByLevelAsc().size();

        for(int i = 0 ; i<size ; i++) {
            Market rp = repository.findAllByOrderByLevelAsc().get(i);
            SimpleList simple = new SimpleList();
            simple.setName(rp.getName());
            simple.setDescription(rp.getDescription());
            simple.setLevel(rp.getLevel());

            if(repository.existsByHoli(rp.getId(), date.format(today))){ //휴무일 여부 확인
                simple.setBusinessStatus("HOLIDAY");
            }else{
                //if(개점시각.isbefore(현재시각) && 현재시각.isbefore(폐점시각))//영업시간인지 확인 필요함 Date()의 before, after활용하기 / 요일에 따른 영업시간 가져오기
                simple.setBusinessStatus("CLOSE");
            }

            simpleLists.add(simple);
        }
        return simpleLists;
    }


    //점포의 상세 정보(점포명, 점포 설명, 주소, 전화번호, level, 조회 일자 기준 영업시간 3일치(오픈시간, 마감시간, 영업상태, 요일))

    @GetMapping("/find")
    public SpecList getMarketFind(int id) {
        SpecList specList = new SpecList();
        Market rp = repository.findById(id).get();
        specList.setId(rp.getId());
        specList.setName(rp.getName());
        specList.setDescription(rp.getDescription());
        specList.setAddress(rp.getAddress());
        specList.setPhone(rp.getPhone());
        specList.setLevel(rp.getLevel());


        List<Business> lB = new ArrayList<Business>();

        //specList.setBusinessDays();
        for(int i = 0;i<3;i++){
            Calendar today = Calendar.getInstance();
            int dd = today.get(Calendar.DAY_OF_WEEK);
            int ff = 0;
            String dayOfWeek = "";
            if(dd+i>7){
                dd = dd - 7;
            }
            switch (dd+i){ // Calender.day_of_week는 1이 일요일 / 컬럼에서는 index(0)가 월요일로 지정되어있음 / 개선사항 : 월요일에 영업을 하지않는경우 오류발생
                default:ff = 5;  break;
                case 2: ff = 0; break;
                case 3: ff = 1; break;
                case 4: ff = 2; break;
                case 5: ff = 3; break;
                case 6: ff = 4; break;
            }

            if(ff !=5) {
                lB.add(rp.getBusinessTimes().get(ff));
            }
        }
        specList.setBusinessDays(lB);
        return specList;
    }


}

