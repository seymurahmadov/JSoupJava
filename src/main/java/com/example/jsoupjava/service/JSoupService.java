package com.example.jsoupjava.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class JSoupService {

    public static void main(String[] args) throws IOException {


        Document document = null;
        document = Jsoup.connect("https://kontakt.az/qadcetleraksesuarlar/qulaqliqlar-bluetooth/?cnt=48").get();


        Elements page = document.getElementsByClass("pagination");
        Elements names = document.getElementsByClass("name");
        Elements prices = document.getElementsByClass("gridprice gridprice_cash");

        //"cart-item "

        Elements div = document.getElementsByClass("cart-item ");
        System.out.println(div.size());
//        System.out.println(div.get(0));

        for (Element element : div){
            Elements name = element.getElementsByClass("name");
            Elements price = element.getElementsByClass("gridprice gridprice_cash");
            System.out.println(name.text() + "---------------------------------" + price.text());
        }






    }
}

