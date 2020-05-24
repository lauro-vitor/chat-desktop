
public class Protocol {

  private String from;
  private String to;
  private String action;
  private String data;

  public Protocol(String message) {
    String[] word = message.split(";");
    for (String w : word) {
      if (w.contains("FROM")) {
        setFrom(w.substring(5));
      }
      if (w.contains("TO")) {
        setTo(w.substring(3));
      }
      if (w.contains("ACTION:")) {
        setAction(w.substring(7));
      }
      if (w.contains("DATA")) {
        setData(w.substring(5));
      }
    }
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
