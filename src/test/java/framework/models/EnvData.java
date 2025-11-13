package framework.models;

import lombok.Getter;

@Getter
public class EnvData {
    private String protocol;
    private String domain;
    private int wait;
    private String host;

    public String getHost() {
        if (domain == null) return protocol + "://" + "";
        String lower = domain.toLowerCase();
        if (lower.startsWith("http://") || lower.startsWith("https://")) {
            return domain;
        }
        return protocol + "://" + domain;
    }

    public int PgLoadWait() {
        return 10;
    }
}
