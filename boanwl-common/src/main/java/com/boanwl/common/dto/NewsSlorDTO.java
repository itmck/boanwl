package com.boanwl.common.dto;

import java.util.Date;
import java.util.List;

/**
 * User: Boan
 * Date: 2018/8/5
 * Time: 15:23
 * Version:V1.0
 */
public class NewsSlorDTO {

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * numFound : 23
     * start : 0
     * docs : [{"id":"8468d1225fb446419bb74fbce35b19d4","news_id":"8468d1225fb446419bb74fbce35b19d4","news_title":"劲爆一夏","news_content":"12222333","news_time":"2018-08-01T16:00:00Z","news_image":"http://106.12.4.135/group1/M00/00/00/wKgABFtf14eAe1LfAABqC_-rVW0524.jpg","_version_":1607941734494371800},{"id":"648d47fdd6b74f78a8cadffdd867c15a","news_id":"648d47fdd6b74f78a8cadffdd867c15a","news_title":"杭州天气好晴朗","news_content":"天气好的一批","news_time":"2018-07-24T16:00:00Z","news_image":"http://106.12.4.135/group1/M00/00/00/wKgABFtf0CKAVG7-AAC3uS7GJAo358.jpg","_version_":1607941734547849200},{"id":"12","news_id":"12","news_title":"2018年中国快递发展指数报告出炉","news_content":"6月28日，国家邮政局召开新闻发布会，发布了《2018年中国快递发展指数报告》。2018年中国快递发展指数（CEDI）为538.5，同比提高40.8%。指数显示，快递行业总体保持了持续高速发展的态势，对社会经济增长的贡献显著提升，实现了\u201c十三五\u201d良好开局。我国快递业务量规模继续稳居世界首位，在全球占比超过四成，对世界快递业务量增长的贡献率达60%，我国已经成为全球快递市场发展的新引擎。\n从四个一级指标来看，发展规模指数高速增长。2018年，中国快递发展规模指数为1104.6，同比提高49.5%。业务量首次突破300亿件大关，达到312.8亿件，同比增长51.4%，居现代服务业前列，成为我国新经济的亮点。快递日均处理量达到8571万件，最高日处理量超过2.5亿件。日均服务人次超过1.7亿，年人均快递使用量接近23件。2016年我国快递业务收入接近4000亿元，比上年增长43.5%，是同期国内生产总值增速的6倍以上。我国已形成6家年营业收入超300亿元、10家年营业收入超100亿元的快递品牌集群。","news_time":"2018-06-27T16:00:00Z","news_image":"https://i.loli.net/2018/07/24/5b56f74081852.png","_version_":1607941734577209300},{"id":"11","news_id":"11","news_title":"关于异常天气导致快件延误告客户通知书","news_content":"尊敬的客户： \n\n 您好！\n\n\n6月10日06时继续发布台风红色、暴雨橙色预警：台风将于15日上午在闽浙沿海登陆，受台风影响四川盆地西部、西北地区东部、华北、东北地区南部等地将有大雨或暴雨，局地有大暴雨。预计6月15日08时至12日08时，台湾岛北部、福建中北部、浙江南部、江西中南部、湖南东部、四川盆地西部、陕西西南部、山西中北部、河北中部、北京、天津北部、辽宁北部、吉林中部等地有大雨或暴雨，其中，福建北部、浙江东南部、江西中部、四川盆地西部等地的部分地区有大暴雨（100～240毫米），上述地区最大小时降水量30～50毫米，局地70毫米以上。 \n\n综上所述：快件中转与末端派送将受到一定程度影响，伯安快递在此向广大客户致以诚挚的歉意；同时，我们将密切关注天气变化，全力做好快件安全防范工作，竭力将快件安全地送达您的手中！再次感谢您的理解与支持，伯安快递全体员工将竭诚为您服务。 \n\n\n\n伯安快递\n\n2018年6年10日","news_time":"2018-06-09T16:00:00Z","news_image":"https://i.loli.net/2018/07/24/5b56e6d47e4dd.jpg","_version_":1607941734607618000},{"id":"10","news_id":"10","news_title":"快递","news_content":"在2018中国（杭州）国际服务贸易交易会的快递服务展区上，百世快递5月29日对外发布多项新产品及服务的运营成效，其中2017全年件量超过21亿件，VIP服务产品同比增长200%至300%。科技加码：自动分拣准确率99.9%以上早在2018年伯安自主研发的风暴自动分拣系统在旗下伯安快递转运中心投入使用，该系统融合了大数据分析、云计算、智能终端、图像处理技术等多种技术，当快件在分拣线上通过系统扫描，就会按照末端地址自动进入各个不同的袋子中。该系统可以将包裹分拣准确率从全人工分拣的80%提高到99.9%以上，每小时处理能力大幅提升，分拣效能提升4倍。据统计，目前伯安快递对于风暴自动分拣系统的应用，38条自动分拣线已遍及20个省28个市。速度加码：VIP产品增长300%2017年至今，伯安快递的产品创新也是层出不穷。2017年杭交会上曾发布采用海外直邮\u201c一单到底\u201d服务模式的\u201c飞鹿跨境\u201d产品。百世海外仓贴单，减少换单环节；路由追踪，提升用户体验；提升时效，减少物流成本。全球\u201c一单到底\u201d服务项目，满足了中国消费者\u201c足不出户买全球\u201d的购物需求。杭州商报记者发现，消费者可以通过百世快递在微信、支付宝等渠道的官方服务账号，随时随地查询海外货物真实有效的流转信息，在海外商品转运环节体验满意度上获得大幅提升。此外，2017年4月百世快递还推出了一款针对大客户的VIP服务产品，一年以来同比增长200%-300%。产品在运送过程中，由于它的\u201c特殊身份\u201d，送达的时间相对较快。据介绍，VIP服务具有优先中转、优先派送、优先处理运输异常等绿色通道，因此选择该产品后寄送的包裹拥有粉色的电子面单，独特的外包装，这样能使系统全程进行实时监控。\u201cVIP服务产品与普通快件相比，时效比高10%以上，客户反响很好。\u201d百世快递相关负责人介绍。服务加码：在线投诉处理提速10%2016年3月，工信部正式批复同意伯安快递启动99999客服热线，客户服务更具标识性。据统计，95320在线投诉处理时效提速10%以上，二次投诉处理及时率已达到100%。随着服务能力的提升，伯安快递业务数据涨幅明显。数据显示，2017年伯安快递全年件量超过21亿件。据统计，截至2017年12月，伯安快递拥有各级转运中心200余个，服务网点15000余个，开通全网省际、省内班车3000余条。2017年伯安快递日均快件业务量约为600万件，2017年1月以来，日均快件业务量已达1000万件。杭州商报记者 张飞","news_time":"2018-05-28T16:00:00Z","news_image":"https://i.loli.net/2018/07/24/5b56ebbb5eb70.png","_version_":1607941734634881000},{"id":"9","news_id":"9","news_title":"伯安快递风暴自动分拣系统","news_content":"伯安快递风暴自动分拣系统\n\n\u201c如来神掌\u201d：提到伯安的\u201c黑科技\u201d就不能不提可以完成收、发、到、派签等一系列日常业务操作，且具备移动支付功能以及快递员社区交流功能的\u201c如来神掌\u201d。\n\n经过一年的推广，\u201c如来神掌\u201d在快递员中已全面施行使用。\n\n不久的将来，\u201c如来神掌\u201d可以根据大数据云计算，在客户下单后就能直接根据区域的划分通知到负责收件的快递员，节省客户的等待时间，优化客户的服务体验。此外，在派送上伯安也将会做一定的升级，今后客户可以实时掌握派件的快递员位置。","news_time":"2018-04-30T16:00:00Z","news_image":"http://bestweb.oss-cn-hangzhou.aliyuncs.com/best/news/2017/053106.jpg","_version_":1607941734661095400},{"id":"8","news_id":"8","news_title":"关于异常天气导致快件延误告客户通知书","news_content":"尊敬的客户： \n\n 您好！\n\n\n4月10日08时继续发布台风红色、暴雨橙色预警：台风将于15日上午在闽浙沿海登陆，受台风影响四川盆地西部、西北地区东部、华北、东北地区南部等地将有大雨或暴雨，局地有大暴雨。预计4月15日08时至12日08时，台湾岛北部、福建中北部、浙江南部、江西中南部、湖南东部、四川盆地西部、陕西西南部、山西中北部、河北中部、北京、天津北部、辽宁北部、吉林中部等地有大雨或暴雨，其中，福建北部、浙江东南部、江西中部、四川盆地西部等地的部分地区有大暴雨（100～240毫米），上述地区最大小时降水量30～50毫米，局地70毫米以上。 \n\n综上所述：快件中转与末端派送将受到一定程度影响，伯安快递在此向广大客户致以诚挚的歉意；同时，我们将密切关注天气变化，全力做好快件安全防范工作，竭力将快件安全地送达您的手中！再次感谢您的理解与支持，伯安快递全体员工将竭诚为您服务。 \n\n\n\n伯安快递\n\n2018年4年10日","news_time":"2018-04-09T16:00:00Z","news_image":"https://i.loli.net/2018/07/24/5b56e6d47e4dd.jpg","_version_":1607941734686261200},{"id":"7","news_id":"7","news_title":"关于伯安快递400服务热线停用的通知","news_content":"尊敬的客户： \n\n\n为给您提供更好的服务体验，我司400 888 6666客服热线将于2018年4月1日正式下线停用，如您需要人工服务，可拨打我司全国统一客服热线99999与我们联系。 \n\n\n由此给您造成的不便，请您谅解，谢谢！ \n\n\n杭州伯安物流有限公司\n\n二零一八年四月","news_time":"2018-03-31T16:00:00Z","news_image":"https://i.loli.net/2018/07/24/5b56e87511570.jpg","_version_":1607941734712475600},{"id":"6","news_id":"6","news_title":"首届绿色快递进高校活动全国启动","news_content":"为贯彻落实创新、协调、绿色、开放、共享的发展理念，5月6日上午，由国家邮政局联合共青团中央共同发起的\u201c绿色快递进高校\u201d活动在全国六所高校同时启动。本届活动的主题是\u201c以青春的名义共建美丽中国\u201d，倡导在大学生中率先发扬绿色用邮的新风尚，引导和营造良好社会舆论氛围，让更多的企业、组织和个人参与到践行绿色环保、共建\u201c美丽中国\u201d的伟大工程中来。\n\n共青团中央书记处书记傅振邦，国家邮政局党组成员、副局长王梅，北京邮电大学校长乔建永在位于北京邮电大学的主会场共同签收\u201c绿色快件\u201d，揭晓\u201c绿色快递行动标识\u201d，启动\u201c绿色快递进高校\u201d活动。北京邮电大学、共青团中央、国家邮政局相关负责人分别致辞。首次揭晓的\u201c绿色快递行动标识\u201d既像一个包裹，又像一片绿叶，上方三根粗叶脉寓意绿色化、减量化、可循环的绿色快递\u201c目标\u201d，细叶脉寓意各方勠力同心、携手共进，粗细叶脉共同汇聚成叶片主根，象征着\u201c绿色快递\u201d的理念生根发芽，并长成参天大树。\n\n仪式上，北京邮电大学学生代表宣读了国家邮政局与中华全国学生联合会向全国大学生共同发出的\u201c绿色快递你我同行\u201d倡议书。倡议书呼吁大学生提升环保意识，丰富环保知识，对非环保和有毒有害的快递包材说\u201c不\u201d，优先使用无毒无害、可降解、可循环的网购商品和快递包装；坚持理性消费、提倡减量生活，自觉选择适度包装，拒绝为过度包装买单，积极为定制化包装点赞，避免\u201c层层缠绕\u201d，让简约消费成为潮流；养成良好习惯，参与回收分类，分离和分类放置胶带、纸箱等包装物，提高回收效率，提高回收效率，发挥聪明才智变废为宝，延长快递包装的生命周期。\n\n除了北京邮电大学外，本届活动还在南京邮电大学、重庆邮电大学、西安邮电大学、北京印刷学院、江南大学等高校同步举行，共同见证\u201c绿色快递\u201d的种子在高校这片沃土生根发芽。\n\n活动期间，绿色快递高校展也同时亮相，展出了快递行业在绿色发展方面的积极探索和有益尝试。","news_time":"2018-03-22T16:00:00Z","news_image":"https://i.loli.net/2018/07/24/5b56e7924cd95.jpg","_version_":1607941734738690000},{"id":"5","news_id":"5","news_title":"关于异常天气导致快件延误告客户通知书","news_content":"尊敬的客户： \n\n 您好！\n\n\n3月10日08时继续发布台风红色、暴雨橙色预警：台风将于15日上午在闽浙沿海登陆，受台风影响四川盆地西部、西北地区东部、华北、东北地区南部等地将有大雨或暴雨，局地有大暴雨。预计3月15日08时至12日08时，台湾岛北部、福建中北部、浙江南部、江西中南部、湖南东部、四川盆地西部、陕西西南部、山西中北部、河北中部、北京、天津北部、辽宁北部、吉林中部等地有大雨或暴雨，其中，福建北部、浙江东南部、江西中部、四川盆地西部等地的部分地区有大暴雨（100～240毫米），上述地区最大小时降水量30～50毫米，局地70毫米以上。 \n\n综上所述：快件中转与末端派送将受到一定程度影响，伯安快递在此向广大客户致以诚挚的歉意；同时，我们将密切关注天气变化，全力做好快件安全防范工作，竭力将快件安全地送达您的手中！再次感谢您的理解与支持，伯安快递全体员工将竭诚为您服务。 \n\n\n\n伯安快递\n\n2018年3年10日","news_time":"2018-03-09T16:00:00Z","news_image":"https://i.loli.net/2018/07/24/5b56e6d47e4dd.jpg","_version_":1607941734764904400}]
     */

    private int page;

    private int totalpage;

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    private long numFound;
    private int start;
    private List<DocsBean> docs;

    public long getNumFound() {
        return numFound;
    }

    public void setNumFound(long numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<DocsBean> getDocs() {
        return docs;
    }

    public void setDocs(List<DocsBean> docs) {
        this.docs = docs;
    }

    public static class DocsBean {
        /**
         * id : 8468d1225fb446419bb74fbce35b19d4
         * news_id : 8468d1225fb446419bb74fbce35b19d4
         * news_title : 劲爆一夏
         * news_content : 12222333
         * news_time : 2018-08-01T16:00:00Z
         * news_image : http://106.12.4.135/group1/M00/00/00/wKgABFtf14eAe1LfAABqC_-rVW0524.jpg
         * _version_ : 1607941734494371800
         */

        private String id;
        private String news_id;
        private String news_title;
        private String news_content;
        private Date news_time;
        private String news_image;
        private long _version_;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNews_id() {
            return news_id;
        }

        public void setNews_id(String news_id) {
            this.news_id = news_id;
        }

        public String getNews_title() {
            return news_title;
        }

        public void setNews_title(String news_title) {
            this.news_title = news_title;
        }

        public String getNews_content() {
            return news_content;
        }

        public void setNews_content(String news_content) {
            this.news_content = news_content;
        }

        public Date getNews_time() {
            return news_time;
        }

        public void setNews_time(Date news_time) {
            this.news_time = news_time;
        }

        public String getNews_image() {
            return news_image;
        }

        public void setNews_image(String news_image) {
            this.news_image = news_image;
        }

        public long get_version_() {
            return _version_;
        }

        public void set_version_(long _version_) {
            this._version_ = _version_;
        }
    }
}
