/*
用StringBuilder
*/
        String str = new String("abdhfgebsa");
        StringBuffer sb = new StringBuffer();
        String v = "aeiouAEIOU";
        for(int i = 0; i < str.length(); i++){
            if(v.indexOf(str.charAt(i)) > -1) continue;         // indexOf 返回index
            sb.append(str.charAt(i));
        }
        str = sb.toString();
        System.out.println(str);
