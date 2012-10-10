package com.ijoyplus;

public class Constant {
    public static final String BASE_URL =
            "http://115.239.196.123/joyplus-service/index.php/";
    public static final String WIKTIONARY_PAGE2 =
            "http://www.baidu.com";
    public static final String OUTPUTFILE ="sdcard/log.txt";
    
    public static final String APPKEY = "ijoyplus_android_0001";
    
    public static final String TEMPMAIL = "T_gcagia";
    
    public  static int TESTINDEX = 3;
    public  static final String PROD_ID = "6315";
    public static String[][] m_URL = {
    	    { "kAppKey  ", BASE_URL +"ijoyplus_ios_001","POST" },
//娴嬭瘯杩炴帴
    	    { "kSuccessResCode  ", BASE_URL +"00000","POST" },
/*
 * 娉ㄥ唽
鍔熻兘璇存槑锛�
鐢ㄦ埛娉ㄥ唽銆�鎺ュ彛褰㈠紡锛�
account/register
璇锋眰鏂瑰紡锛�
POST
鍙傛暟锛�
app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�username required string 鎺堟潈鐢ㄦ埛鐨勭敤鎴峰悕銆傚繀椤绘槸鐢靛瓙閭欢鏍煎紡
password required string 鎺堟潈鐢ㄦ埛鐨勫瘑鐮併�
nickname required string 鎺堟潈鐢ㄦ埛鏄电О
杩斿洖鍊硷細

{
  res_code: [String], // res 缂栫爜
  res_desc: [String], // res 鎻忚堪

}
 */
    	    { "kPathAccountRegister ", BASE_URL +"account/register","POST","4","app_key","username","password","nickname","RETURN","2","res_code","res_desc"},
/*
 * 鐧诲綍
鍔熻兘璇存槑锛�
鐢ㄦ埛鐧婚檰銆�鎺ュ彛褰㈠紡锛�
account/login
璇锋眰鏂瑰紡锛�
POST
鍙傛暟锛�
app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�   
username required string 鎺堟潈鐢ㄦ埛鐨勭敤鎴峰悕銆�password required string 鎺堟潈鐢ㄦ埛鐨勫瘑鐮併�
杩斿洖鍊硷細

{
  res_code: [String], // res code
  res_desc: [String], // res desc

}
 */
  	    { "kPathAccountLogin ", BASE_URL +"account/login","POST","3","app_key","username","password","RETURN","2","res_code","res_desc"},



/*
 * 获取节目的内容New Page Edit Page Page History
功能说明：

获得某节目内容
接口形式：

program/view
请求方式：

GET
参数：

app_key required string 申请应用时分配的AppKey。
prod_id required string 节目id
返回值：

1：如果是电视剧

 {
  tv: {
    name: [STRING], // 节目的名字，255字节以内的字符串
    summary: [STRING], // 节目的简介，255字节以内的字符串
    poster: [URL], // 节目的海报图片地址，字符串格式符合http协议地址格式
    closed: [BOOL], // 表示节目是否已经完结，true或者false
    episodes_count: [NUM], // 节目的总集数，正整数
    sources: [STRING] // 节目的可用来源网站，以逗号分割的字符串，例如：优酷,土豆,...
    like_num: int //喜欢这个节目的用户数
    watch_num: int //观看过这个节目的用户数
    favority_num: int 收藏这个节目的用户数,
    episodes: [
    {
      name: [STRING],
      video_urls: [
        {
          source: [STRING], // 节目的可用来源网站，例如：优酷,土豆
          url: [URL]
        },
        ...
      ]
     },
     ...
    ]
  },
  comments: [
   {
    owner_id: int 发表评论的用户id
    owner_name: string 发表评论用户名
    owner_pic_url: string 发表评论用户的头像
    id: int 评论id
    content: string 评论的内容
    create_date: date 评论时间
   }
   ......
   ]
 }
2：如果是综艺节目

{
show: {
    name: [STRING], // 节目的名字，255字节以内的字符串
    summary: [STRING], // 节目的简介，255字节以内的字符串
    poster: [URL], // 节目的海报图片地址，字符串格式符合http协议地址格式
    closed: [BOOL], // 表示节目是否已经完结，true或者false
    episodes_count: [NUM], // 节目的总集数，正整数
    sources: [STRING] // 节目的可用来源网站，以逗号分割的字符串，例如：优酷,土豆,...
    like_num: int //喜欢这个节目的用户数
    watch_num: int //观看过这个节目的用户数
    favority_num: int 收藏这个节目的用户数,
    episodes: [
    {
      name: [STRING],
      video_urls: [
        {
          source: [STRING], // 节目的可用来源网站，例如：优酷,土豆
          url: [URL]
        },
        ...
       ]
     },
    ...
   ]
 },
 comments: [
  {
    owner_id: int 发表评论的用户id
    owner_name: string 发表评论用户名
    owner_pic_url: string 发表评论用户的头像
    id: int 评论id
    content: string 评论的内容
    create_date: date 评论时间
   }
   ......
 ]
 }
3：如果是电影

{
  movie: {
    name: [STRING], // 节目的名字，255字节以内的字符串
     summary: [STRING], // 节目的简介，255字节以内的字符串
     poster: [URL], // 节目的海报图片地址，字符串格式符合http协议地址格式
     like_num: int //喜欢这个节目的用户数
     watch_num: int //观看过这个节目的用户数
     favority_num: int 收藏这个节目的用户数,
     video_urls: [
        {
           source: [STRING], // 节目的可用来源网站，例如：优酷,土豆 
           url: [URL]
        }
        .........
     ]
   },
  comments: [
  {
    owner_id: int 发表评论的用户id
    owner_name: string 发表评论用户名
    owner_pic_url: string 发表评论用户的头像
    id: int 评论id
    content: string 评论的内容
    create_date: date 评论时间
   }
     ......
   ]
 }
 */
    	    { "kPathProgramView ", BASE_URL +"program/view","GET","2","app_key","prod_id","RETURN","XML"},
/*
 * 某个节目好友推荐New Page Edit Page Page History
功能说明：

获得好友推荐的节目内容
接口形式：

program/viewRecommend
请求方式：

GET
参数：

app_key required string 申请应用时分配的AppKey。
prod_id required string 节目id
返回值：

1：如果是电视剧

 {
  tv: {
    name: [STRING], // 节目的名字，255字节以内的字符串
    summary: [STRING], // 节目的简介，255字节以内的字符串
    poster: [URL], // 节目的海报图片地址，字符串格式符合http协议地址格式
    closed: [BOOL], // 表示节目是否已经完结，true或者false
    episodes_count: [NUM], // 节目的总集数，正整数
    sources: [STRING] // 节目的可用来源网站，以逗号分割的字符串，例如：优酷,土豆,...
    like_num: int //喜欢这个节目的用户数
    watch_num: int //观看过这个节目的用户数
    favority_num: int 收藏这个节目的用户数,
    episodes: [
    {
      name: [STRING],
      video_urls: [
        {
          source: [STRING], // 节目的可用来源网站，例如：优酷,土豆
          url: [URL]
        },
        ...
      ]
     },
     ...
    ]
  },
  comments: [
   {
    owner_id: int 发表评论的用户id
    owner_name: string 发表评论用户名
    owner_pic_url: string 发表评论用户的头像
    id: int 评论id
    content: string 评论的内容
    create_date: date 评论时间
   }
   ......
   ]

 "dynamics": {
    "favority": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    "watch": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    "share": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
        "share_where_type": 分享到哪儿，1:新浪，2：腾讯，3：人人网，4：豆瓣
    },
   "recommend": { //推荐节目
        "user_id": 用户id
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 时间
        "reason":推荐原因
    },
    "comment": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
        "content": 评论的内容
    },
    "publish": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },,
    "like": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    。。。。。。。。。

   }
 }
2：如果是综艺节目

{
show: {
    name: [STRING], // 节目的名字，255字节以内的字符串
    summary: [STRING], // 节目的简介，255字节以内的字符串
    poster: [URL], // 节目的海报图片地址，字符串格式符合http协议地址格式
    closed: [BOOL], // 表示节目是否已经完结，true或者false
    episodes_count: [NUM], // 节目的总集数，正整数
    sources: [STRING] // 节目的可用来源网站，以逗号分割的字符串，例如：优酷,土豆,...
    like_num: int //喜欢这个节目的用户数
    watch_num: int //观看过这个节目的用户数
    favority_num: int 收藏这个节目的用户数,
    episodes: [
    {
      name: [STRING],
      video_urls: [
        {
          source: [STRING], // 节目的可用来源网站，例如：优酷,土豆
          url: [URL]
        },
        ...
       ]
     },
    ...
   ]
 },
 comments: [
  {
    owner_id: int 发表评论的用户id
    owner_name: string 发表评论用户名
    owner_pic_url: string 发表评论用户的头像
    id: int 评论id
    content: string 评论的内容
    create_date: date 评论时间
   }
   ......
 ]


 "dynamics": {
    "favority": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    "watch": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    "share": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
        "share_where_type": 分享到哪儿，1:新浪，2：腾讯，3：人人网，4：豆瓣
    },
    "comment": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
        "content": 评论的内容
    },
    "publish": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },,
    "like": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    。。。。。。。。。

  }

 }
3：如果是电影

{
  movie: {
    name: [STRING], // 节目的名字，255字节以内的字符串
     summary: [STRING], // 节目的简介，255字节以内的字符串
     poster: [URL], // 节目的海报图片地址，字符串格式符合http协议地址格式
     like_num: int //喜欢这个节目的用户数
     watch_num: int //观看过这个节目的用户数
     favority_num: int 收藏这个节目的用户数,
     video_urls: [
        {
           source: [STRING], // 节目的可用来源网站，例如：优酷,土豆 
           url: [URL]
        }
        .........
     ]
   },
  comments: [
  {
    owner_id: int 发表评论的用户id
    owner_name: string 发表评论用户名
    owner_pic_url: string 发表评论用户的头像
    id: int 评论id
    content: string 评论的内容
    create_date: date 评论时间
   }
     ......
   ]


"dynamics": {
    "favority": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    "watch": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    "share": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
        "share_where_type": 分享到哪儿，1:新浪，2：腾讯，3：人人网，4：豆瓣
    },
    "comment": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
        "content": 评论的内容
    },
    "publish": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },,
    "like": {
        "user_id": 用户id 
        "user_name": 用户名
        "user_pic_url": 用户头像
        "create_date": 操作时间
    },
    。。。。。。。。。

 }

 }
 */
    	    { "kPathProgramViewRecommend ", BASE_URL +"program/viewRecommend","GET","2","app_key","prod_id","RETURN","XML"},
    	    //Program

/*
 * 鑾峰緱鏌愯妭鐩殑璇勮New Page Edit Page Page History
鍔熻兘璇存槑锛�
鑾峰緱鏌愯妭鐩殑璇勮
鎺ュ彛褰㈠紡锛�
program/comments
璇锋眰鏂瑰紡锛�
GET
鍙傛暟锛�
app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�
prod_id required string 鑺傜洰id
page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
杩斿洖鍊硷細

{
comments: [
    {
        owner_id: int 鍙戣〃璇勮鐨勭敤鎴穒d
        owner_name: string 鍙戣〃璇勮鐢ㄦ埛鍚�        owner_pic_url: string 鍙戣〃璇勮鐢ㄦ埛鐨勫ご鍍�        id: int 璇勮id
        content: string 璇勮鐨勫唴瀹�        create_date: date 璇勮鏃堕棿
    }
    ......
  ]
}
 */
    	    { "kPathProgramComments ", BASE_URL +"program/comments","GET","4","app_key","prod_id","page_num","page_size","RETURN","XML"},

    	  //Search
/*
 * 获取当前最热搜索关键字New Page Edit Page Page History
功能说明：

获得最热搜索
接口形式：

/search/topKeywords
请求方式：

GET
参数：

app_key required string 申请应用时分配的AppKey。
num option 条数，可选，默认为10条
返回值：

{
"topKeywords": [
    {
        "content": 关键词
        "search_count": 搜索次数
        "last_search_date": 最新搜索时间
    }
 ]
}
 */
    	    { "kPathSearchTopKeywords ", BASE_URL +"search/topKeywords","GET","2","app_key","num","RETURN","XML"},
    	  
    	   /*
    	    * 鑾峰緱鐢ㄦ埛淇℃伅New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛淇℃伅
    	   鎺ュ彛褰㈠紡锛�
    	   user/view
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�
    	   userid required string 鐢ㄦ埛id锛�鍙�锛岄粯璁や负褰撳墠鐢ㄦ埛
    	   杩斿洖鍊硷細

    	    {
    	      "id": 鐢ㄦ埛id
    	      "username": 鐢ㄦ埛鍚�   "nickname": 鐢ㄦ埛鏄电О
    	      "email": 鐢靛瓙閭欢
    	      "phone": 鐢佃瘽鍙风爜
    	       "pic_url": 澶村儚
    	       "bg_url": 鑳屾櫙鍥剧墖
    	       "like_num": 鍠滄鎴戝彂甯冭妭鐩殑鐢ㄦ埛鏁�    "follow_num": 鎴戝叧娉ㄧ殑鐢ㄦ埛鏁�    "fan_num": 鎴戠殑绮変笣涔� }	    
    	    */
    	       	    { "kPathUserView ", BASE_URL +"user/view","GET","2","app_key","userid","RETURN","10","id","username","nickname","email","phone","pic_url","bg_url","like_num","follow_num","fan_num"},
    	   /*
    	    * 鑾峰緱缁戝畾浜嗙涓夋柟璐﹀彿鐨勭敤鎴峰垪琛∟ew Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛绗笁鏂硅处鍙峰ソ鍙嬪垪琛�鎺ュ彛褰㈠紡锛�
    	   user/thirdPartyUsers
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�source_type required string 绗笁鏂硅处鍙风被鍒� 1:鏂版氮锛�锛氳吘璁紝3锛氫汉浜虹綉锛�锛氳眴鐡�5:鏈湴閫氳褰�杩斿洖鍊硷細

    	    {
    	     "users": [
    	       {
    	           "friend_id":  ijoyplus绯荤粺鐨勭敤鎴穒d
    	           "thirdpart_id":  绗笁鏂圭郴缁熺殑鐢ㄦ埛id
    	       }
    	     ]
    	   }
    	    */
    	       	    { "kPathUserThirdPartyUsers ", BASE_URL +"user/thirdPartyUsers","GET","2","app_key","source_type","RETURN","2","friend_id","thirdpart_id"},

    	   /*
    	    * 鑾峰緱鍏虫敞鐢ㄦ埛New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛鐨勫叧娉ㄧ敤鎴�鎺ュ彛褰㈠紡锛�
    	   user/friends
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�userid required string 鐢ㄦ埛id锛屽彲閫夛紝榛樿涓哄綋鍓嶇敤鎴�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細

    	   {
    	       "friends": [
    	         {
    	           "id": 鐢ㄦ埛id
    	            "nickname": 鐢ㄦ埛鍚�        "user_pic_url": 鐢ㄦ埛澶村儚
    	         },
    	       銆傘�銆傘�銆傘�
    	     ]
    	    }
    	    */
    	       	    { "kPathUserFriends ", BASE_URL +"user/friends","GET","4","app_key","userid","page_num","page_size","RETURN","XML"},
    	   /*
    	    * 鑾峰彇绮変笣New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛鐨勭矇涓�鎺ュ彛褰㈠紡锛�
    	   user/fans
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�userid required string 鐢ㄦ埛id锛屽彲閫夛紝榛樿涓哄綋鍓嶇敤鎴�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細

    	    {
    	      "fans": [
    	       {
    	           "id": 鐢ㄦ埛id
    	           "nickname": 鐢ㄦ埛鍚�        "user_pic_url": 鐢ㄦ埛澶村儚
    	       },
    	       .......
    	      ]
    	    }
    	    */
    	       	    { "kPathUserFans ", BASE_URL +"user/fans","GET","4","app_key","userid","page_num","page_size","RETURN","2","id","nickname","user_pic_url"},
    	   /*
    	    * 鑾峰彇濂藉弸鎺ㄨ崘New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱濂藉弸鎺ㄨ崘
    	   鎺ュ彛褰㈠紡锛�
    	   friend/recommends
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細

    	   {
    	    recommends: [
    	       {
    	           content_id: [INT] //鑺傜洰id
    	           content_name: [STRING] //鑺傜洰鍚嶇О
    	           content_pic_url: [STRING] 鑺傜洰鐨勬捣鎶ュ湴鍧�        content_type: [INT] //鑺傜洰绫诲瀷 1锛氱數褰憋紝2锛氱數瑙嗗墽锛�锛氱患鑹鸿妭鐩�        recommendRate: [INT] //鎺ㄨ崘搴�    }
    	       ......
    	     ]
    	   }
    	    */
    	       	    { "kPathFriendRecommends ", BASE_URL +"friend/recommends","GET","3","app_key","page_num","page_size","RETURN","XML"},
    	   /*
    	    * 鑾峰彇濂藉弸鍔ㄦ�New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛濂藉弸鐨勫姩鎬�鎺ュ彛褰㈠紡锛�
    	   user/friendDynamics
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   user_id 鐢ㄦ埛id锛屽彲閫夛紝榛樿涓哄綋鍓嶇敤鎴�杩斿洖鍊硷細

    	    {
    	     "dynamics": {
    	       "reply": {   //鍥炲璇勮
    	           "user_id": 鐢ㄦ埛id
    	           "user_name": 鐢ㄦ埛鍚�        "user_pic_url": 鐢ㄦ埛澶村儚
    	           "create_date": 鏃堕棿
    	           "prod_type": 鑺傜洰绫诲瀷 1锛氱數褰憋紝2锛氱數瑙嗗墽锛�锛氱患鑹鸿妭鐩�        "prod_name": 鑺傜洰鍚嶇О
    	           "prod_poster": 鑺傜洰娴锋姤
    	           "prod_id": 鑺傜洰id
    	           "thread_id": 璇勮id
    	           "thread_comment": 璇勮鐨勫唴瀹�        "content": 鍥炲鐨勫唴瀹�    },
    	       銆傘�銆傘�銆傘�銆�    }
    	     } 
    	    */
    	       	    { "kPathUserFriendDynamics ", BASE_URL +"user/friendDynamics","GET","4","app_key","page_num","page_size","user_id","RETURN","XML"},
    	   /*
    	    * 鑾峰彇褰撳墠鐢ㄦ埛鍜屽ソ鍙嬬殑鍔ㄦ�New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛鍜屼粬鐨勫ソ鍙嬬殑鍔ㄦ�
    	   鎺ュ彛褰㈠紡锛�
    	   user/friendAndMeDynamics
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   user_id 鐢ㄦ埛id锛屽彲閫夛紝榛樿涓哄綋鍓嶇敤鎴�杩斿洖鍊硷細

    	    {
    	     "dynamics": {
    	       "reply": {   //鍥炲璇勮
    	           "user_id": 鐢ㄦ埛id
    	           "user_name": 鐢ㄦ埛鍚�        "user_pic_url": 鐢ㄦ埛澶村儚
    	           "create_date": 鏃堕棿
    	           "prod_type": 鑺傜洰绫诲瀷 1锛氱數褰憋紝2锛氱數瑙嗗墽锛�锛氱患鑹鸿妭鐩�        "prod_name": 鑺傜洰鍚嶇О
    	           "prod_poster": 鑺傜洰娴锋姤
    	           "prod_id": 鑺傜洰id
    	           "thread_id": 璇勮id
    	           "thread_comment": 璇勮鐨勫唴瀹�        "content": 鍥炲鐨勫唴瀹�    },
    	       銆傘�銆傘�銆傘�銆�    }
    	     } 
    	    */
    	       	    { "kPathfriendAndMeDynamics ", BASE_URL +"user/friendAndMeDynamics","GET","4","app_key","page_num","page_size","user_id","RETURN","XML"},
    	   /*
    	    * 鑾峰彇閫氱煡淇℃伅New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛鐨勯�鐭ヤ俊鎭�鎺ュ彛褰㈠紡锛�
    	   user/msgs
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細
    	    XML
    	    .........................
    	    */
    	       	    { "kPathUserMsgs ", BASE_URL +"user/msgs","GET","3","app_key","page_num","page_size","RETURN","XML"},
    	  
    	   /*
    	    * 鑾峰彇鏌愪釜浜虹湅杩囩殑鑺傜洰New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛鐪嬭繃鐨勮妭鐩竻鍗�鎺ュ彛褰㈠紡锛�
    	   user/watchs
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�userid required string 鐢ㄦ埛id锛屽彲閫夛紝榛樿涓哄綋鍓嶇敤鎴�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細

    	   {
    	      watchs: [
    	         {
    	             "content_id": 鑺傜洰id
    	             "content_name": 鑺傜洰鍚�          "content_pic_url": 鑺傜洰鐨勬捣鎶�          "content_type": 鑺傜洰鐨勭被鍨�1锛氱數褰憋紝2锛氱數瑙嗗墽锛�锛氱患鑹鸿妭鐩�          "create_date"锛� 瑙傜湅鐨勬椂闂�      },
    	        .......
    	      ]
    	    }
    	    */
    	       	    { "kPathUserWatchs ", BASE_URL +"user/watchs","GET","4","app_key","userid","page_num","page_size","RETURN","XML"},
    	   /*
    	    * 鑾峰彇鏌愪釜浜烘帹鑽愯繃鐨勮妭鐩甆ew Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛鎺ㄨ崘杩囩殑鑺傜洰娓呭崟
    	   鎺ュ彛褰㈠紡锛�
    	   /user/recommends
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�userid required string 鐢ㄦ埛id锛屽彲閫夛紝榛樿涓哄綋鍓嶇敤鎴�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細

    	   {
    	      watchs: [
    	         {
    	             "content_id": 鑺傜洰id
    	             "content_name": 鑺傜洰鍚�          "content_pic_url": 鑺傜洰鐨勬捣鎶�          "content_type": 鑺傜洰鐨勭被鍨�1锛氱數褰憋紝2锛氱數瑙嗗墽锛�锛氱患鑹鸿妭鐩�          "reason"锛� 鎺ㄨ崘鍘熷洜
    	             "create_date"锛� 鎺ㄨ崘鏃堕棿
    	         },
    	        .......
    	      ]
    	    }
    	    */
    	       	    { "kPathUserRecommends ", BASE_URL +"user/recommends","GET","4","app_key","userid","page_num","page_size","RETURN","2","res_code","res_desc"},
    	   /*
    	    * 鑾峰彇鏌愪釜浜烘敹钘忕殑鑺傜洰New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰緱鐢ㄦ埛鏀惰棌杩囩殑鑺傜洰娓呭崟
    	   鎺ュ彛褰㈠紡锛�
    	   /user/favorities
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�userid required string 鐢ㄦ埛id锛屽彲閫夛紝榛樿涓哄綋鍓嶇敤鎴�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細

    	   {
    	      watchs: [
    	         {
    	             "content_id": 鑺傜洰id
    	             "content_name": 鑺傜洰鍚�          "content_pic_url": 鑺傜洰鐨勬捣鎶�          "content_type": 鑺傜洰鐨勭被鍨�1锛氱數褰憋紝2锛氱數瑙嗗墽锛�锛氱患鑹鸿妭鐩�          "create_date"锛� 鏀惰棌鏃堕棿
    	         },
    	        .......
    	      ]
    	    }
    	    */
    	       	    { "kPathUserFavorities ", BASE_URL +"user/favorities","GET","4","app_key","userid","page_num","page_size","RETURN","XML"},
    	       	    //Comments
    	 
    	   /*
    	    * 鑾峰緱鏌愯瘎璁虹殑鍥炲New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰彇鏌愯瘎璁虹殑鍥炲
    	   鎺ュ彛褰㈠紡锛�
    	   comment/replies
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�thread_id required string 璇勮鐨刬d銆�page_num = 闇�璇锋眰鐨勯〉鐮侊紙鍙�锛夛紝榛樿涓�
    	   page_size = 姣忎竴椤靛寘鍚殑璁板綍鏁帮紙鍙�锛夛紝榛樿涓�0
    	   杩斿洖鍊硷細

    	   {
    	     replies: [
    	       {
    	               owner_id: [INT] //鐢ㄦ埛鐨刬d 
    	               owner_name: [STRING] 鐢ㄦ埛鍚�            owner_pic_url: [STRING] // 鐢ㄦ埛澶村儚
    	               id: [INT] //鍥炲璇勮id,
    	               content: [STRING] 鍥炲鐨勫唴瀹�            create_date: [DATE] 鍥炲璇勮鐨勬椂闂�    }
    	     ....
    	     ]
    	   }
    	    */
    	       	    { "kPathCommentReplies ", BASE_URL +"comment/replies","GET","4","app_key","thread_id","page_num","page_size","RETURN","XML"},
    	   /*
    	    * 鑾峰彇璇勮鍐呭New Page Edit Page Page History
    	   鍔熻兘璇存槑锛�
    	   鑾峰彇璇勮鐨勫唴瀹癸紝骞朵笖鍖呭惈10鏉℃渶鏂扮殑璇勮鍥炲
    	   鎺ュ彛褰㈠紡锛�
    	   comment/view
    	   璇锋眰鏂瑰紡锛�
    	   GET
    	   鍙傛暟锛�
    	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�
    	   thread_id required string 璇勮鐨刬d銆�杩斿洖鍊硷細

    	   {
    	     comment: {
    	       owner_id: [INT] //鐢ㄦ埛鐨刬d 
    	       owner_name: [STRING] 鐢ㄦ埛鍚�    owner_pic_url: [STRING] // 鐢ㄦ埛澶村儚
    	       id: [INT] //璇勮id,
    	       content: [STRING] 璇勮鐨勫唴瀹�    create_date: [DATE] 鍙戣〃璇勮鐨勬椂闂�    replies: [
    	           {
    	               owner_id: [INT] //鐢ㄦ埛鐨刬d 
    	               owner_name: [STRING] 鐢ㄦ埛鍚�            owner_pic_url: [STRING] // 鐢ㄦ埛澶村儚
    	               id: [INT] //鍥炲璇勮id,
    	               content: [STRING] 鍥炲鐨勫唴瀹�            create_date: [DATE] 鍥炲璇勮鐨勬椂闂�        }
    	          .......
    	       ]
    	    }
    	    */
    	       	    { "kPathCommentView", BASE_URL +"comment/view","GET","2","app_key","thread_id","RETURN","XML"},
    	       	 /*
    	       	  * 鏀惰棌鑺傜洰New Page Edit Page Page History
    	       	 鍔熻兘璇存槑锛�
    	       	 鏀惰棌鑺傜洰锛屾敹钘忎綘鎰熷叴瓒ｇ殑鑺傜洰锛屾柟渚夸互鍚庤鐪嬪拰鎺ㄨ崘缁欏ソ鍙�鎺ュ彛褰㈠紡锛�
    	       	 program/favority
    	       	 璇锋眰鏂瑰紡锛�
    	       	 POST
    	       	 鍙傛暟锛�
    	       	 app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�
    	       	 prod_id required string 鑺傜洰鐨刬d
    	       	 杩斿洖鍊硷細

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 }
    	       	  */
    	       	     	    { "kPathProgramFavority ", BASE_URL +"program/favority","POST","2","app_key","prod_id","RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 鍙栨秷鏀惰棌鑺傜洰New Page Edit Page Page History
    	       	 鍔熻兘璇存槑锛�
    	       	 鍙栨秷浣犳敹钘忕殑鑺傜洰
    	       	 鎺ュ彛褰㈠紡锛�
    	       	 program/unfavority
    	       	 璇锋眰鏂瑰紡锛�
    	       	 POST
    	       	 鍙傛暟锛�
    	       	 app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�
    	       	 prod_id required string 鑺傜洰鐨刬d
    	       	 杩斿洖鍊硷細

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 }
    	       	  */
    	       	     	    { "kPathProgramUnfavority ", BASE_URL +"program/unfavority","POST","2","app_key","prod_id","RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 璇勮鑺傜洰New Page Edit Page Page History
    	       	 鍔熻兘璇存槑锛�
    	       	 瀵瑰枩娆㈡垨涓嶅枩娆㈢殑鑺傜洰鍙戣〃鑷繁鐨勬劅鍙楋紝璇勮
    	       	 鎺ュ彛褰㈠紡锛�
    	       	 program/comment
    	       	 璇锋眰鏂瑰紡锛�
    	       	 POST
    	       	 鍙傛暟锛�
    	       	 app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�
    	       	 prod_id required string 琚瘎璁虹殑鑺傜洰id
    	       	 content required string 璇勮鐨勫唴瀹�杩斿洖鍊硷細

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 }
    	       	  */
    	       	     	    { "kPathProgramComment ", BASE_URL +"program/comment","POST","2","app_key","prod_id","content","RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 观看节目New Page Edit Page Page History
    	       	 功能说明：

    	       	 如果你观看了节目，需要调用这个接口
    	       	 接口形式：

    	       	 program/watch
    	       	 请求方式：

    	       	 POST
    	       	 参数：

    	       	 app_key required string 申请应用时分配的AppKey。
    	       	 prod_id required string 节目id
    	       	 返回值：

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 }
    	       	  */
    	       	     	    { "kPathProgramWatch ", BASE_URL +"program/watch","POST","2","app_key","prod_id","RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 分享节目New Page Edit Page Page History
    	       	 功能说明：

    	       	 分享节目，如果你分享接到到第三方系统，你需要调用这个接口，目前有新浪，腾讯，人人网，豆瓣
    	       	 接口形式：

    	       	 program/share
    	       	 请求方式：

    	       	 POST
    	       	 参数：

    	       	 app_key required string 申请应用时分配的AppKey。
    	       	 prod_id required string 被分享的节目id
    	       	 where   required string 分享哪儿， 1:新浪，2：腾讯，3：人人网，4：豆瓣
    	       	 返回值：

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 }
    	       	  */
    	       	     	    { "kPathProgramShare ", BASE_URL +"program/share","POST","3","app_key","prod_id","where", "RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 发布节目New Page Edit Page Page History
    	       	 功能说明：

    	       	 发布节目。没有被发布的节目，你才能发布
    	       	 接口形式：

    	       	 program/publish
    	       	 请求方式：

    	       	 POST
    	       	 参数：

    	       	 app_key required string 申请应用时分配的AppKey。
    	       	 prod_id required string 节目id
    	       	 返回值：

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 }   	    
    	       	  */
    	       	     	    { "kPathProgramShare ", BASE_URL +"program/share","POST","2","app_key","prod_id", "RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 推荐节目New Page Edit Page Page History
    	       	 功能说明：

    	       	 推荐节目，推荐过的节目可能会在好友推荐里出现
    	       	 接口形式：

    	       	 program/recommend
    	       	 请求方式：

    	       	 POST
    	       	 参数：

    	       	 app_key required string 申请应用时分配的AppKey。
    	       	  prod_id required string 节目id
    	       	 reason option string 推荐理由
    	       	 返回值：

    	       	   {
    	       	     res_code: [String], // res code
    	       	     res_desc: [String], // res desc

    	       	   }   	    
    	       	  */
    	       	     	    { "kPathProgramRecommend ", BASE_URL +"program/recommend","POST","3","app_key","prod_id","reason","RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 隐藏推荐节目New Page Edit Page Page History
    	       	 功能说明：

    	       	 隐藏推荐节目，此节目不会在好友推荐和好友的推荐列表中出现
    	       	 接口形式：

    	       	 program/hiddenRecommend
    	       	 请求方式：

    	       	 POST
    	       	 参数：

    	       	 app_key required string 申请应用时分配的AppKey。
    	       	 prod_id required string 节目id
    	       	 返回值：

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 } //prod_id :6315
    	       	  */
    	       	     	    { "kPathProgramHiddenRecommend ", BASE_URL +"program/hiddenRecommend","POST","2","app_key","prod_id","RETURN","2","res_code","res_desc"},
    	       	 /*
    	       	  * 隐藏观看过节目New Page Edit Page Page History
    	       	 功能说明：

    	       	 隐藏观看过的节目，此节目不会在好友的观看列表中出现
    	       	 接口形式：

    	       	 program/hiddenWatch
    	       	 请求方式：

    	       	 POST
    	       	 参数：

    	       	 app_key required string 申请应用时分配的AppKey。
    	       	 prod_id required string 节目id
    	       	 返回值：

    	       	 {
    	       	   res_code: [String], // res code
    	       	   res_desc: [String], // res desc

    	       	 }
    	       	  */
    	       	     	    { "kPathProgramHiddenWatch ", BASE_URL +"program/hiddenWatch","POST","2","app_key","prod_id","RETURN","2","res_code","res_desc"},
    	       	 /*
    	     	    * 瀹屽杽涓汉璧勬枡
    	     	   鍔熻兘璇存槑锛�
    	     	   鐢ㄧ涓夋柟璐﹀彿鐧婚檰鍚庯紝闇�瀹屽杽涓汉璧勬枡锛屽叾涓寘鎷樀绉帮紝鐢靛瓙閭欢锛屽瘑鐮佺瓑銆�鎺ュ彛褰㈠紡锛�
    	     	   account/updateProfile
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�username required string 鎺堟潈鐢ㄦ埛鐨勭敤鎴峰悕銆傚繀椤绘槸鐢靛瓙閭欢
    	     	   password required string 鎺堟潈鐢ㄦ埛鐨勫瘑鐮併�
    	     	   nickname required string 鎺堟潈鐢ㄦ埛鏄电О
    	     	   source_id required string 绗笁鏂硅处鍙风敤鎴穒d銆�source_type required string 绗笁鏂硅处鍙风被鍒� 1:鏂版氮锛�锛氳吘璁紝3锛氫汉浜虹綉锛�锛氳眴鐡�杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res 缂栫爜
    	     	     res_desc: [String], // res 鎻忚堪

    	     	   }
    	     	    */
    	     	       	    { "kPathAccountUpdateProfile ", BASE_URL +"account/updateProfile","POST","6","app_key","username","password","nickname","source_id","source_type","RETURN","2","res_code","res_desc"},
    	       	 /*
    	     	    * 缁戝畾鎵嬫満鍙风爜New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   缁戝畾鎵嬫満鍙风爜锛岀敤浜庡叾瀹冪敤鎴烽�杩囨湰鍦伴�璁綍瀵绘壘濂藉弸
    	     	   鎺ュ彛褰㈠紡锛�
    	     	   account/bindPhone
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�phone required string 鎵嬫満鍙风爜銆�杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	       	    { "kPathAccountBindPhone ", BASE_URL +"account/bindPhone","POST","2","app_key","phone","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	    * 鍙栨秷绗笁鏂硅处鍙风粦瀹歂ew Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   鍙栨秷缁戝畾绗笁鏂硅处鍙凤紝鐩墠鍙互缁戝畾璞嗙摚锛岃吘璁紝鏂版氮锛屼汉浜虹綉鐨勫井鍗氳处鍙�鎺ュ彛褰㈠紡锛�
    	     	   account/unbindAccount
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�source_type required string 绗笁鏂硅处鍙风被鍒� 1:鏂版氮锛�锛氳吘璁紝3锛氫汉浜虹綉锛�锛氳眴鐡�杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   } 
    	     	    */
    	     	       	    { "kPathunbindAccount ", BASE_URL +"account/unbindAccount","POST","2","app_key","source_type","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	    * 蹇樿瀵嗙爜New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   蹇樿瀵嗙爜锛岄�杩囧彂閫佺數瀛愰偖浠堕噸缃敤鎴峰瘑鐮�鎺ュ彛褰㈠紡锛�
    	     	   account/forgotPwd
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�loginname required string 鐢ㄦ埛鍚�鐢ㄦ埛鐢靛瓙閭欢
    	     	   杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	    //Not support   	    { "kPathforgotPwd ", BASE_URL +"account/forgotPwd","POST","2","app_key","loginname","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	    * 鍏虫敞鐢ㄦ埛New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   鍏虫敞鐢ㄦ埛锛屼綘鍙互鎵归噺鍏虫敞澶氫釜/涓�釜鐢ㄦ埛
    	     	   鎺ュ彛褰㈠紡锛�
    	     	   friend/follow
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�friend_ids required string 浣犲笇鏈涘叧娉ㄧ敤鎴风殑id锛屾瘡涓敤鎴风殑id浠�鍒嗗紑銆傛瘮濡�1,12,14
    	     	   杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	      	    { "kPathfriendfollow ", BASE_URL +"friend/follow","POST","2","app_key","friend_ids","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	   * 鍠滄鐢ㄦ埛New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   鍠滄鐢ㄦ埛锛屼綘鍙互鎵归噺鍠滄澶氫釜/涓�釜鐢ㄦ埛
    	     	   鎺ュ彛褰㈠紡锛�
    	     	   friend/like
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�user_id required string 浣犲笇鏈涘枩娆㈢敤鎴风殑id
    	     	   杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	       	    { "kPathfriendlike ", BASE_URL +"friend/like","POST","2","app_key","user_id","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	    * 鍙栨秷鍏虫敞鐢ㄦ埛New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   鍙栨秷鍏虫敞鐢ㄦ埛锛屼綘鍙互鎵归噺鍙栨秷鍏虫敞澶氫釜/涓�釜鐢ㄦ埛
    	     	   鎺ュ彛褰㈠紡锛�
    	     	   friend/destory
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�friend_ids required string 浣犲笇鏈涘彇娑堝叧娉ㄧ敤鎴风殑id锛屾瘡涓敤鎴风殑id浠�鍒嗗紑銆傛瘮濡�1,12,14
    	     	   杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	       	    { "kPathFriendDestory ", BASE_URL +"friend/destory","POST","2","app_key","friend_ids","RETURN","2","res_code","res_desc"},
    	       	 /*
    	     	    * 鏇存柊鐢ㄦ埛澶村儚New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   鏇存柊鐢ㄦ埛鐨勫ご鍍忓湴鍧�鎺ュ彛褰㈠紡锛�
    	     	   user/updatePicUrl
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆� url required URL 鐢ㄦ埛澶村儚鍦板潃(http)
    	     	   杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	       	    { "kPathUserUpdatePicUrl ", BASE_URL +"user/updatePicUrl","POST","2","app_key","url","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	    * 鏇存柊鐢ㄦ埛鑳屾櫙鍥剧墖New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   鏇存柊鐢ㄦ埛鐨勫ご鍍忓湴鍧�鎺ュ彛褰㈠紡锛�
    	     	   user/updateBGPicUrl
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆� url required URL 鐢ㄦ埛澶村儚鍦板潃(http)
    	     	   杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	      	    { "kPathUserUpdateBGPUrl ", BASE_URL +"user/updateBGPicUrl","POST","2","app_key","url","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	    * 涓婁紶骞堕鐢熸垚绗笁鏂硅处鍙风敤鎴峰垪琛∟ew Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   棰勭敓鎴愮敤鎴风涓夋柟璐﹀彿鐢ㄦ埛鍒楄〃
    	     	   鎺ュ彛褰㈠紡锛�
    	     	   user/preGenThirdpartUsers
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�source_ids required string 绗笁鏂硅处鍙风殑濂藉弸id锛屼互,鍒嗛殧 姣斿123,123
    	     	   source_type required string 绗笁鏂硅处鍙风被鍒� 1:鏂版氮锛�锛氳吘璁紝3锛氫汉浜虹綉锛�锛氳眴鐡�5:鏈湴閫氳褰�杩斿洖鍊硷細

    	     	     {
    	     	       res_code: [String], // res code
    	     	       res_desc: [String], // res desc

    	     	     }
    	     	    */
    	     	       	    { "kPathUserPreGenThirdPartyUsers ", BASE_URL +"user/preGenThirdPartyUsers","POST","3","app_key","source_ids","source_type","RETURN","2","res_code","res_desc"},
    	       	  /*
    	     	    * 鍥炲璇勮New Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   鍥炲璇勮
    	     	   鎺ュ彛褰㈠紡锛�
    	     	   comment/reply
    	     	   璇锋眰鏂瑰紡锛�
    	     	   POST
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�thread_id required string 璇勮鐨刬d
    	     	   content required string 鍥炲鐨勫唴瀹癸紝鏈�暱涓嶈兘瓒呰繃140瀛�杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	       	    { "kPathCommentReply ", BASE_URL +"comment/reply","POST","3","app_key","thread_id","content","RETURN","2","res_code","res_desc"},
    	     	   /*
    	     	    * 缁戝畾绗笁鏂硅处鍙種ew Page Edit Page Page History
    	     	   鍔熻兘璇存槑锛�
    	     	   缁戝畾绗笁鏂硅处鍙凤紝鐩墠鍙互缁戝畾璞嗙摚锛岃吘璁紝鏂版氮锛屼汉浜虹綉鐨勫井鍗氳处鍙�鎺ュ彛褰㈠紡锛�
    	     	   account/bindAccount
    	     	   璇锋眰鏂瑰紡锛�
    	     	   GET
    	     	   鍙傛暟锛�
    	     	   app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�source_id required string 绗笁鏂硅处鍙风敤鎴穒d銆�source_type required string 绗笁鏂硅处鍙风被鍒� 1:鏂版氮锛�锛氳吘璁紝3锛氫汉浜虹綉锛�锛氳眴鐡�杩斿洖鍊硷細

    	     	   {
    	     	     res_code: [String], // res code
    	     	     res_desc: [String], // res desc

    	     	   }
    	     	    */
    	     	       	    { "kPathAccountBindAccount ", BASE_URL +"account/bindAccount","POST","3","app_key","source_id","source_type","RETURN","2","res_code","res_desc"},
    	       	 /*
    	    	     * 娉ㄩ攢New Page Edit Page Page History
    	    	    鍔熻兘璇存槑锛�
    	    	    鐢ㄦ埛鐧诲嚭銆�鎺ュ彛褰㈠紡锛�
    	    	    account/logout
    	    	    璇锋眰鏂瑰紡锛�
    	    	    GET
    	    	    鍙傛暟锛�
    	    	    app_key required string 鐢宠搴旂敤鏃跺垎閰嶇殑AppKey銆�杩斿洖鍊硷細

    	    	    {
    	    	      res_code: [String], // res code
    	    	      res_desc: [String], // res desc

    	    	    }
    	    	     */
    	       	    
    	    	   { "kPathAccountLogout ", BASE_URL +"account/logout","GET","1","app_key","RETURN","2","res_code","res_desc"}

    };
    public static String[][] m_ReturnErrorCode = {
    		{"10021", "HTTP method is not suported for this request" },
    		{"10006", "Source paramter (appkey) is missing or invalid" },
    		{"10001", "System error" },
    		 { "20001", "Account not Found"},
    		    { "20002", "Password is invalid"},
    		    { "20003", "Username is invalid,It must be your email."},
    		    { "20004", "Username can\'t be null"},
    		    { "20005", "Password can\'t be null"},
    		    { "20006", "Username exists."},
    		    { "20008", "Session is expired, need relogin."},   
    		    { "20009", "Third part account type is invalid."},     
    		    { "20010", "Object not found"},
    		    { "20011", "Param is invalid"},
    		    { "20013", "Program is published."},
    		    { "20014", "Url is invalid."},
    		    { "20015", "Program is favority."},
    		    { "20016", "Program is not favority."},
    		    { "20017", "Person is liked by you."},
    		    { "20018", "Nickname can not be null"},
    		        { "20019", "Nickname is exsting."},
    		        { "20020", "Keyword can\'t be null."}
    };
    public static  String[][] m_ReturnOKCode = {
    { "00000", "Success" }};
}
