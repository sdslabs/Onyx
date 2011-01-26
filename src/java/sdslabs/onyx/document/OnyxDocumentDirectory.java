package sdslabs.onyx.document;


public class OnyxDocumentDirectory {

  private List<OnyxDocument> documents;
  private int lastIndex;

  public OnyxDocumentDirectory(){
    documents = new HashMap<OnyxDocument>();  
    lastIndex = -1;
  }

  public void addDocument( OnyxDocument doc ){
    documents.add(doc);
  }

  public OnyxDocument getDocument( int index ){
    return documents.get(i);
  }

  public OnyxDocument iterateDocument(){
    lastIndex++;
    if(lasIndex == documents.size())
      return null;
    return documents.get(lastIndex);
  }
  
}


