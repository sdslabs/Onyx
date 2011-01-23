package org.apache.lucene.store;

import java.io.IOException;

class CassandraInputStream extends IndexInput implements Cloneable {

  static final int BUFFER_SIZE = CassandraOutputStream.BUFFER_SIZE;

  CassandraInputStream(CassandraFile file) throws IOException {
   
  
  }

  @Override
  public void close(){

  }

  @Override
  public long length(){

  } 

  @Override
  public byte readByte() throws IOException {

  }

  @Override
  public void readBytes(byte[] b, int offset, int len) throws IOException {

  }

  @Override
  public void copyBytes(IndexOutput out, long numBytes) throws IOException {


  }

  @Override
  public long getFilePointer(){

  }

  @Override
  public void seek(long pos) throws IOException {

  }

}
 

