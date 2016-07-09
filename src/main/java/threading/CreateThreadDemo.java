/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

/**
 *
 * @author PraS an
 */
public class CreateThreadDemo {
    public static void main(String[] args) {
        new CreateThreadDemo().runApp();
    }
    
    public void runApp(){
        //if thread class subclass
        FileStore filestore=new FileStore();
        
        
        // if implemented class of runnable interface
        Thread fileDownloader=new Thread(new FileDownloader());
        
        filestore.start();
        fileDownloader.start();
    }
    
}

//Runnable Implement
class FileDownloader implements Runnable{
    
    @Override
    public void run() {
        System.out.println("File Downloader");
    
    }


}

//Thread class
class FileStore extends Thread{

    @Override
    public void run() {
        System.out.println("File Store");
    }
}