package sdslabs.onyx.document;

public interface OnyxDocument {

  public void addDocument(File file);
  public void addMetaData(Map<String,List<String>> metadata);
  public Document getDocument();
  public Map<String,List<String>> getMetaData();
  public String getType();
  
}
