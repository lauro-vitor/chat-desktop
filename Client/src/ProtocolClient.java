
public class ProtocolClient {

  private String from;
  private String to;
  private String action;
  private String data;
  private String[] arrayData = null;
  private String[] requireProtocol = null;
  private String[] word = null;

  public ProtocolClient(String message, String require) {
    requireProtocol = message.split("}");
    if (require.equalsIgnoreCase("GROUP")) {
      word = requireProtocol[0].split(";");
    } else if (require.equalsIgnoreCase("CHAT")) {
      if (requireProtocol.length > 1) {
        word = requireProtocol[1].split(";");
      }
    }
    for (String w : word) {
      if (w.contains("FROM")) {
        from = w.substring(5);
      }
      if (w.contains("TO")) {
        to = w.substring(3);
      }
      if (w.contains("ACTION:")) {
        action = w.substring(7);
      }
      if (w.contains("DATA")) {
        data = w.substring(5);
        String aux = data;
        if (aux.contains("§§")) {
          arrayData = aux.split("§§");
        }
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

  public String[] getArrayData() {
    return this.arrayData;
  }
}
