package com.java.OOP;

interface Parseable{
    public abstract void parse(String fileName);
}

class ParserManager {

    // 리턴 타입이 Parseable 인터페이스 -> Parseable 인터페이스를 구현한 클래스를 리턴
    public static Parseable getParser(String type){
        if(type.equals("XML")){
            return new XMLParser();
        }
        else{
            Parseable p = new HTMLParser();
            return p;
        }
    }
}

class XMLParser implements Parseable{
    public void parse(String fileName){
        System.out.println(fileName + " - XML parsing completed");
    }
}

class HTMLParser implements Parseable{
    public void parse(String fileName){
        System.out.println(fileName + "- HTML parsing completed");
    }
}

class ParserTest{
    public static void main(String[] args) {

        Parseable parser = ParserManager.getParser("XML");
        parser.parse("document.xml");

        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");
    }

}