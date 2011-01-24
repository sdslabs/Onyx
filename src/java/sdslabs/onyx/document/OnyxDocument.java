package sdslabs.onyx.document;

public interface OnyxDocument {

  public void addDocument(File file);
  public void addMetaData(HashMap<String,String> metadata);
  public Document getDocument();
  public HashMap<String,String> getMetaData();
  public String getType();

}
