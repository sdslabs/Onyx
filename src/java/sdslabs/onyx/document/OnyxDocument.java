package sdslabs.onyx.document;

public interface OnyxDocument {

  public void addDocument(File file);
  public void addMetaData(HashMap<String,List<String>> metadata);
  public Document getDocument();
  public HashMap<String,List<String>> getMetaData();
  public String getType();
  
}
