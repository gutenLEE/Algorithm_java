package com.java.Exception;

public class ChainedExceptionEX {
    public static void main(String[] args) {
        try{
            install();
        }
        catch(InstallException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    static void install() throws InstallException{
        try{
            startInstall();
            copyFiles();
        }
        catch(SpaceException e){
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(e);
            throw ie;
        }
        catch (MemoryException me){
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(me);
            throw ie;
        }
        finally {
            deleteTempFile();
        }
    }
    static void startInstall() throws SpaceException, MemoryException{
        if(!enoughSpace()){
            throw new SpaceException("설치할 공간이 부족합니다");
        }
        if(!enoughMemory()){
            throw new MemoryException("메모리가 부족합니다.");
        }
    }

    static void copyFiles(){}
    static void deleteTempFile(){}

    static boolean enoughSpace(){
        return false;
    }
    static  boolean enoughMemory(){
        return true;
    }
}
class InstallException extends Exception{
    InstallException(String msg){
        super(msg);
    }
}
class SpaceException extends Exception{
    SpaceException(String msg){
        super(msg);
    }
}
class MemoryException extends Exception{
    MemoryException(String msg){
        super(msg);
    }
}


