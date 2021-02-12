package com.daimler.sechub.developertools.admin.ui.util;

import java.util.SortedMap;

/**
 * Why this class and not just using {@link java.util.Properties} ? Because we
 * want to have value content being JSON - and this makes problems in
 * properties. Also there are some special characters in
 * {@link java.util.Properties} which is not wanted.
 * 
 * @author Albert Tregnaghi
 *
 */
public class SortedMapToTextConverter {

    public String convertToText(SortedMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return sb.toString();
        }
        for (String key : map.keySet()) {
            if (key == null || key.isEmpty()) {
                continue;
            }
            String value = map.get(key);
            if (value == null || value.isEmpty()) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(key).append('=').append(value);
        }
        return sb.toString();
    }

}
