 package com.keyword;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author MysteryGuest
 * @date 2021/07/10
 */
public class TransientCase {

    /**
     * @description 使用transient关键字不序列化某个变量
     * 注意读取的时候，读取数据的顺序一定要和存放数据的顺序保持一致
     * @param args
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SubSerializable subs = new SubSerializable();
        subs.setNumWithoutTransient(23);
        subs.setStrWithTransient("It uses the key word transient.");
        SubSerializable.setByteWithStatic(Byte.MIN_VALUE);
        
        System.out.println("It reads before Serializable: ");
        System.out.println("numWithoutTransient: "+subs.getNumWithoutTransient());
        System.out.println("strWithTransient: "+subs.getStrWithTransient());
        System.out.println("byteWithStatic: "+SubSerializable.getByteWithStatic());
        
        try {
            /*
             * public ObjectOutputStream(OutputStream out)
                   throws IOException
             * public FileOutputStream(String name) throws FileNotFoundException {
                   this(name != null ? new File(name) : null, false);
               }
             * */
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/keyword/subs.txt"));
            // 将指定的对象写入ObjectOutputStream
            oos.writeObject(subs);
            // 刷新流
            oos.flush();
            oos.close();
            
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        } catch (IOException e) {
             e.printStackTrace();
        }
        
        try {
            // 在反序列化之前改变username的值
            SubSerializable.setByteWithStatic(Byte.MAX_VALUE);
            
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/com/keyword/subs.txt"));
            SubSerializable subsAfterSerializable = (SubSerializable)ois.readObject();
            ois.close();
            
            
            System.out.println("It reads after Serializable: ");
            System.out.println("numWithoutTransient: "+subsAfterSerializable.getNumWithoutTransient());
            System.out.println("strWithTransient: "+subsAfterSerializable.getStrWithTransient());
            System.out.println("byteWithStatic: "+SubSerializable.getByteWithStatic());
            
            
        } catch (IOException e) {
             e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
       }
        
        SubExternalizable sube = new SubExternalizable();
        // 实现Externalizable接口的类的实例序列化与实现serialiable接口的类的实例序列化所有api不同
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/com/keyword/sube.txt"));
        oos.writeObject(sube);
        oos.flush();
        

        ObjectInput ois = new ObjectInputStream(new FileInputStream("src/com/keyword/sube.txt"));
        
        /*
         * SubExternalizable类必须显式加上无参构造方法，否则会报下面错
         * Exception in thread "main" java.io.InvalidClassException: com.keyword.SubExternalizable; no valid constructor
         */
        sube = (SubExternalizable)ois.readObject();
        System.out.println(sube.getContent());
        
        oos.reset();
        oos.writeObject("使用内部方法反序列化，传字符赋给content");
        oos.flush();
        sube.readExternal(ois);
        System.out.println(sube.getContent());
        
        oos.close();
        ois.close();

    }

}

class SubSerializable implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private int numWithoutTransient;
    private transient String strWithTransient;
    private static byte byteWithStatic;

    public int getNumWithoutTransient() {
        return numWithoutTransient;
    }

    public void setNumWithoutTransient(int numWithoutTransient) {
        this.numWithoutTransient = numWithoutTransient;
    }

    public String getStrWithTransient() {
        return strWithTransient;
    }

    public void setStrWithTransient(String strWithTransient) {
        this.strWithTransient = strWithTransient;
    }

    // 静态变量静态方法
    public static byte getByteWithStatic() {
        return byteWithStatic;
    }

    public static void setByteWithStatic(byte byteWithStatic) {
        SubSerializable.byteWithStatic = byteWithStatic;
    }
}

/**
 * @descripiton Externalizable接口的使用
 * */
class SubExternalizable implements Externalizable{
    
    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";
    
    /**
     * 必须有无参数的构造器
     */
    public SubExternalizable() {
        
    }
    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    /* (non-Javadoc)
     * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        com.keyword.SubExternalizable cannot be cast to java.lang.String
//        content = (String) in.readObject();

        content = (String) in.readObject();
    }
    
}
