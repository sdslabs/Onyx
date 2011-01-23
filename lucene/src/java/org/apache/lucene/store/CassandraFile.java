package org.apache.lucene.store;

import java.util.ArrayList;
import java.io.Serializable;


public class CassandraFile implements Serializable {

  private static final long serialVersionUID = 1l;

  CassandraDirectory directory;
  long length;
  protected long sizeInBytes;
  //cassandra interface

  private long lastModified = System.currentTimeMillis();
  
  protected CassandraFile(){}

  
  CassandraFile(CassandraDirectory directory){
    this.directory = directory;
  }
  
  public synchronized long getLength(){
    return length;
  }

  protected synchronized void setLength(long length){
    this.length = length;
  }

  public synchronized long getLastModified(){
    return lastModified;
  }

  protected synchronized void setLastModified(long lastModified){
    this.lastModfied = lastModified;
  }

  protected final byte[] addBuffer( int size){

  }

  protected final synchronized byte[] getBuffer(int index){
    
  }

  protected final synchronized int numBuffers(){

  }

  protected byte[] newBuffer(int size){

  }

  public synchronized long getSizeInBytes(){
    return sizeInBytes;
  }

  
}

