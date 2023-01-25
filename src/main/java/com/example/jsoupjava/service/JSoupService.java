package com.example.jsoupjava.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class JSoupService {

    public static void main(String[] args) throws IOException {

      Document  pageCount = Jsoup.connect("https://kontakt.az/telefonlar/qulaqliqlar-umumi/qulaqliqlar-bluetooth").get();

        Elements page = pageCount.getElementsByClass("page larger");
        int size = page.size();
        Element element = page.get(size - 1);
        String pageNumber= element.text();

        for (int i = 1; i <=Integer.parseInt(pageNumber) ; i++) {


          Document  document = Jsoup.connect("https://kontakt.az/telefonlar/qulaqliqlar-umumi/qulaqliqlar-bluetooth/page/" + i).get();


            Elements div = document.getElementsByClass("cart-item ");
            System.out.println(div.size() + "*********************************************");
//        System.out.println(div.get(0));

            for (Element element1 : div) {
                Elements name = element1.getElementsByTag("a");
                Elements price = element1.getElementsByClass("gridprice gridprice_cash");
                System.out.println(name.text() + "---------------------------------" + price.text());
            }


        }

    }
}

