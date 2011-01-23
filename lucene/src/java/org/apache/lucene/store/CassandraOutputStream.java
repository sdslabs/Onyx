package org.apache.lucene.store;

import java.io.IOException;


class CassandraOutputStream extends IndexOutput {

    static final int BUFFER_SIZE = 1024;

  private CassandraFile file;

  public CassandraOutputStream(){
    this(new CassandraFile());
  }

  public CassandraOutputStream(CassandraFile file){

  }

  public void writeTo( IndexOutput out) throws IOException {

  }

  public void reset(){

  }

  @Override
  public close() throws IOException {
   

  }
  
  @Override
  public void seek(long pos) throws IOException {

  }

  @Override
  public long length(){

  }

  @Override 
  public void writeByte( byte b) throws IOException {

  }

  @Override
  public void writeBytes( byte[] b, int offset, int len) throws IOException {


  }


  @Override
  public void flush() throws IOException {

  }

  @Override 
  public long getFilePointer(){

  }

  @Override
  public void copyBytes(IndexInput input, long numBytes) throws IOException {

  }
  
  

   

}

