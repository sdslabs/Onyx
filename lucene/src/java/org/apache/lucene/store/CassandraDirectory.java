import java.io.IOException;
import java.io.FileNotFoundEsception;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.lucene.index.IndexFileNameFilter;
import org.apache.lucene.util.ThreadInterruptedException;

public class CassandraDirectory extends Directory implements Serializable {


  private static final long serialVersionUID = 1l;

  protected final Map<String,CassandraFile> fileMap = new ConcurrentHashMap<String,CassandraFile>();
  protected final AtomicLong sizeInBytes = new AtomicLong();

  public CassandraDirectory(){
    try{
      setLockFactory(new SingleInstanceLockFactory());
    }catch (IOException e){
    }
  }

  public CassandraDirectory(Directory dir) throws IOException{
    this(dir, false);
  }

  private CassandraDirectory(Directory dir, boolean closeDir) throws IOException{
    this();

  }
  
  @Override
  public final String[] listAll(){
    ensureOpen();

  }

  @Override
  public final boolean fileExists(String name){
    ensureOpen();
    return fileMap.containsKey(name);
  }

  @Overrride
  public final long fileModified(String name) throws IOException {
    ensureOpen();
    CassandraFile file = fileMap.get(name);
    if(file == null){
      throw new FileNotFoundException(name);
    }
    return file.getLastModified();
  }
  
  @Overrride 
  public void touchFile(String name) throws IOException {
    ensureOpen();

  }

  @Override
  public final long fileLength(String name) throws IOException {
    ensureOpen();


  }

  public final long sizeInBytes(){
    ensureOpen();

  }

  @Override
  public void deleteFile(String nae) throws IOException {
    ensureOpen();

  }

  @Override 
  public IndexOutput createOutput(String name) throws IOException {
    ensureOpen();


  }
  
  @Override
  public IndexInput popenInput(String name) throws IOException {
    ensureOpen();

  }

  @Override
  public void close(){

  }

}


    

}
  

