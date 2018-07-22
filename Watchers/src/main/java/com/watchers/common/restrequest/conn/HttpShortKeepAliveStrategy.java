package com.watchers.common.restrequest.conn;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class HttpShortKeepAliveStrategy implements ConnectionKeepAliveStrategy {
	
    @Override
    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
        
        HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        while (it.hasNext()) {
            HeaderElement he = it.nextElement();
            String param = he.getName();
            String value = he.getValue();
            if (value != null && param.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value) * 100;
                } catch (NumberFormatException ignore) {
                }
            }
        }
 
        return 5 * 1000;
    }
}
