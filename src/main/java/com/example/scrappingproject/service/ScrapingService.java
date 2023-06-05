package com.example.scrappingproject.service;

import com.example.scrappingproject.dto.BinaDTO;
import com.example.scrappingproject.entity.BinaEntity;
import com.example.scrappingproject.repository.BinaRepository;
import com.example.scrappingproject.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScrapingService {

private final Mapper mapper;
private final BinaRepository repository;

    public void getData() throws IOException{

        int page = 1;
        int pageexist = 0;

        while(pageexist<20){
            org.jsoup.nodes.Document pageTest =  Jsoup.connect("https://bina.az/baki/alqi-satqi/menziller/yeni-tikili?floor_first=false&floor_last=false&has_bill_of_sale=true&has_repair=true&page="+page).get();
             org.jsoup.nodes.Document doc = Jsoup.parse(String.valueOf(pageTest));

            Elements cardParams = doc.select(".card_params");
            if (cardParams.isEmpty()) {

                pageexist = 20;
                System.out.println("Bitti");

            } else {
                log.info("Scrap begin");
                for (Element cardParam : cardParams) {
                    String price = String.valueOf(cardParam.getElementsByClass("price").text());
                    String location = String.valueOf(cardParam.getElementsByClass("location").text());
                    String info = String.valueOf(cardParam.getElementsByClass("name").text());
                    String date = String.valueOf(cardParam.getElementsByClass("city_when").text());
                    BinaDTO dto = new BinaDTO(price,location,info,date);
                    log.info("Scrap get dto:" +dto.toString());
                    BinaEntity entity = mapper.dtoToEntity(dto);
                    log.info("Scrap get entity:" +entity.toString());
                    repository.save(entity);

                }
                page++;
        }
            pageexist++;
    }


    }
    public List<BinaDTO> getalldata(){
       return  repository.findAll().stream().map(n->mapper.entityToDto(n)).collect(Collectors.toList());
    }

}
