package businesslogic.bl.center;

import java.io.File;
import java.util.ArrayList;

public class PackageListener {
	 
	FileListenerThread f ;
	
    public PackageListener(String filePath) {
        String path = filePath;
        f = new FileListenerThread(path);
        Thread listener = new Thread(f);
        listener.start();
    }

}
 
class FileListenerThread implements Runnable{
 
    private String path;
    ArrayList<String> addedFile = new ArrayList<String>();
    @Override
    public void run() {
        //需要监听的文件夹
        File file = new File(path);
        //原始文件中的文件数量
        String[] fileList = file.list();
        int orginalSize = file.list().length;
        while(true){
            int size = file.list().length;
            if(size > orginalSize){
               // System.out.println("文件新增，数量为： "+(size-orginalSize));
            	String[] newFileList = file.list();
            	for(int i=0;i<newFileList.length;i++){
            		boolean isOld = false;
            		for(int j=0;j<fileList.length;j++){
            			if(newFileList[i].equals(fileList[j])){
            				isOld = true;
            				break;
            			}

            		}
            		
        			if(!isOld){
        				addNewFile(newFileList[i]);
        				System.out.println(newFileList[i]);
        			}
            	}
            	
            	//System.out.println("?????");
            	fileList = newFileList;
                orginalSize = size;
            }
         
            try {
                //睡1秒
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
    }
     
    private void addNewFile(String newFileName) {
		// TODO Auto-generated method stub
    	addedFile.add(newFileName);
		
	}
    
    public ArrayList<String> getAddedFileList(){
    	ArrayList<String> temp = addedFile;
    	addedFile.clear();
    	return temp;
    }

	public FileListenerThread(String path){
        this.path= path;
    }
}
 