package ml.yihao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author zyh
 * @Description:
 * @date 2021/2/92:49 下午
 */
public class HJ19 {
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Integer> map = new LinkedHashMap<String, Integer>();
        String line = null;
        while((line = br.readLine()) != null && !"".equals(line)){
            String[] sa = line.split("\\s+");
            // 截取文件名称
            // 要求取后有效16位
            String fileName = getFileName(sa[0]);
            fileName = fileName + " " + sa[1];
            Integer v = map.get(fileName);
            if(v == null){
                map.put(fileName, 1);
            }else{
                map.put(fileName, v + 1);
            }

        }

        int cnt = 0;
        for(Map.Entry entry : map.entrySet()){
            if(map.size() - cnt <= 8){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            cnt ++;
        }

        Pattern compile = Pattern.compile("123");
    }

    public static String getFileName(String path){
        if(path == null || "".equals(path)){
            return null;
        }

        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        // 取后16位
        fileName = fileName.substring(Math.max(fileName.length() - 16,0));
        return fileName;

    }

}
