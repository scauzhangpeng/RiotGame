package org.scau.riotgame.hero;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ZP on 2018/2/26.
 */

public class HeroDetailBean extends Hero {


    /**
     * use_skill2 : 【E透体之劲】会对冲击波里的任何人造成全额伤害。用它来攻击敌方小兵，从而击中躲在小兵身后的敌方英雄。
     * skill5_expend : 消耗：100/125/150 法力
     * opponent_reason1 : 锤石的超强保护能力经常让蔚有来无回
     * skill3_cooling :
     * color : 0xb4384d,0xc34a24,0xa5c34a24
     * skill5_damage :
     * active : true
     * skill4_damage :
     * skill3_add :
     * use_skill3 : 【R天霸横空烈轰】是一个强大的先手手段，只要记得别把剩余的队友远远甩在身后就好。
     * skill5_cooling : 冷却时间：130/100/70秒
     * skill4_expend : 消耗：40/45/50/55/60法力
     * story : 对于蔚来说，所有问题都只是一道墙壁，一道可以用她的巨型海克斯科技拳套一拳打穿的墙壁而已。尽管她的成长过程总是伴随着违法乱纪，但现在，蔚将她的犯罪本领用来为皮尔特沃夫警方服务。蔚的傲慢态度、粗俗幽默和公然抗命，经常会激怒她那循规蹈矩的搭档，凯特琳。但即使是皮城女警也无法否认，在与犯罪团伙的斗争中，蔚是一个无价之宝。
     * <p>
     * 蔚的童年时代在皮尔特沃夫的一个不受法律约束的郊区度过。为了生存下去，她学会了抢劫和诈骗。通过偷窃并拆散海克斯科技硬件，她掌握了熟练的机械技术。而流落街头的生活教会了她要依靠自己。当她长到六岁时，一个下层社会的犯罪团伙对这个年轻的小太妹产生了好感，并把她带进了他们的组织。在蔚十一岁的时候，她已经成为了一个老练的帮众，并且她非常享受每次抢劫时的律动感。
     * <p>
     * 蔚的态度的转变，是在一次对采矿设施发起袭击的时候。当时情况变糟了，而她被迫在两个选项中做出选择：是和她的帮派一起逃走，还是从一个倒塌的隧道里救出那些无辜的矿工。蔚选择扮演英雄的角色。在寻找着一个能够让矿工们从碎石堆中重返自由的方式的时候，她发现了一个已经损坏的人形采矿机体。她突发奇想，将它两个的巨型拳头拆了下来，并将它们改造成了将就可用的海克斯科技拳套。在给她的小手戴上重型武器后，这个小太妹缩紧了她的手臂，然后对准碎石堆挥出了动力十足的重拳。重击的力量将石头击得粉碎。矿工们重返自由，而蔚则逃离了现场。
     * <p>
     * 在那单活搞砸了后，蔚切断了与帮派的联系。她又回到了独自犯罪的生活中，但她只从其它犯罪团伙那里偷东西。时光荏苒，蔚改造并优化了她的海克斯科技铁拳，让她能够毫不费力地抢劫并夺走赃物。最后，她的恶名已经传到了凯特琳，著名的皮城女警长那里。但凯特琳没有去试图逮捕蔚，而是为这个太妹提供了一条向社会还债的方式：在皮尔特沃夫里为法律效劳。蔚笑了。她立刻就同意了。现在，凯特琳正在努力管束着蔚，而蔚则把凯特琳的命令看作是微不足道的建议，但当她们在一起工作时，皮城的所有违法者们都会恐惧不已。
     * <p>
     * “真遗憾。我有两只拳头，但你的脸上只放得下一只。”——蔚
     * best_partner1 : 58
     * group :
     * partner_reason1 : 两个人同时冲击后排，技能为队友创造输出环境，又能逼迫对面C位将输出打在己方肉上
     * skill5_add :
     * skill2_expend : 消耗：50/60/70/80/90 法力
     * skill3 : ViW.png|爆弹重拳（W）
     * skill2 : ViQ.png|强能冲拳（Q）
     * skill1 : ViPassive.png|爆裂护盾（被动）
     * skill3_damage :
     * skill3_expend : 无消耗
     * skill5 : ViR.png|天霸横空烈轰（R）
     * skill4 : ViE.png|透体之劲（E）
     * last_modify_date : 2017-11-13 15:16:33
     * teamwork : 团战能R到对面C位就果断开打，进去后AE后如果对面集火你可以Q出来，也可以硬抗，给队友争取时间。
     * hero_id : 254
     * discount_end_date : 2016-08-02 00:00:00
     * op_skill : EPHK-石伟豪：保证Q的命中，QAE打出W的被动。Q蓄力时可接闪现后再Q，速刷野到6
     * use_skill1 : 一记完全充能的【Q强能冲拳】会造成双倍伤害。它在追击并了结溃散的敌人时非常有效。
     * insert_date : 2014-05-12 11:48:07
     * comment_info :
     * discount_begin_date : 2016-07-29 10:00:00
     * skill2_add :
     * skill4_cooling : 冷却时间：1/1/1/1/1秒
     * best_partner2 : 7
     * newhero_end_date : 2016-09-13 00:00:00
     * skill3_desc : 被动
     * 对相同目标的每第三次攻击会造成额外物理伤害，伤害值为目标最大生命值的4/5.5/7/8.5/10%(+0.029%*额外AD)，减少目标20%的护甲，并为蔚提供30/35/40/45/50%攻击速度加成，持续4秒（对野怪和小兵最多造成300伤害）。
     * 距离：750
     * ag_skill3 : 蔚会在使用大招时免疫控制效果。记得把你的位移技能留到她的冲锋完成之后使用。
     * skill5_desc : 标记并追击一名敌方英雄，将目标击飞1.25秒，造成150/300/450(+1.4*额外AD)物理伤害。
     * <p>
     * 在冲锋时，蔚不会被中止，并且会将沿途的敌人击退到两边，同时对他们造成75%的伤害。
     * 距离：700
     * skill4_desc : 使下一次普通攻击对目标和目标身后的敌人造成10/30/50/70/90(+1.15*AD)(+0.7*AP)物理伤害。
     * <p>
     * 蔚每14/12.5/11/9.5/8秒都会积攒一发新的重拳效果，并且可以同时持有两发重拳效果。
     * 距离：600
     * skill4_add :
     * skill2_cooling : 冷却时间：16/14/12/10/8秒
     * skill2_damage :
     * strongest_opponent1 : 412
     * strongest_opponent2 : 40
     * partner_reason2 : 只要控住对方脆皮，妖姬一套轻松带走
     * newhero_begin_date : 2016-08-30 12:13:03
     * opponent_reason2 : 风女的大招让你的位移归为虚无
     * skill2_desc : 积蓄力量，以准备进行一次能够带着蔚一起冲刺的强力重拳。
     * <p>
     * 第一次施放：你的移动速度减少15%，与此同时，在1.25秒的持续时间里提升伤害和冲刺距离。
     * <p>
     * 第二次施放：向前冲刺，对命中的所有敌人造成55/80/105/130/155(+0.8*额外AD)到110/160/210/260/310(+1.6*额外AD)物理伤害，并施加爆弹重拳的效果（对小兵和野怪造成75%的伤害）。在命中一名敌方英雄后停下，并将该英雄击退。"
     * <p>
     * 击退持续时间： 0.7秒
     * 距离：250-750
     * <p>
     * ag_skill2 : 如果蔚连续击中你三次，她会击碎你的护甲并获得攻击速度加成。尽量不要在大型械斗中和她接战。
     * skill1_desc : 你的主动技能会在命中一名敌人时为你提供一层持续3秒的护盾，护盾的生命值相当于你最大生命值的10%（冷却时间：16-8秒(于1-18级)。
     * play_list : [{"first4_num":1,"insert_date":"2015-11-25 10:45:22","smooth_desc":"","smooth1":"3111","smooth3":"3156","smooth2":"3074","smooth5":"3742","smooth4":"3143","bad_rune":"精华：高级生命值精华 x3\r\n印记：高级护甲穿透印记 x9\r\n符印：高级护甲符印 x9\r\n雕纹：高级成长魔法抗性雕纹 x9","smooth6":"3083","smooth_author":"ID豆子","smooth_rune":"精华：高级生命值精华 x3\r\n印记：高级护甲穿透印记 x9\r\n符印：高级护甲符印 x9\r\n雕纹：高级成长魔法抗性雕纹 x9","id":1291,"bad_inborn":"12 0 18","bad6":"3083","bad5":"3742","bad4":"3053","bad3":"3143","bad2":"3074","bad1":"3111","smooth_inborn":"12 0 18","smooth_level":"超凡大师","first7_num":1,"bad_author":"ID豆子","add":"QEWWWR EWWQRQ QQEREE","bad_desc":"","first1_num":1,"first5_num":1,"bad_level":"超凡大师","last_modify_date":"2017-03-01 17:47:19","first1":"1054","first2":"2003","first3":"3340","first4":"","first5":"","first6":"","first7":"","first3_num":1,"name":"上单打法","first2_num":1,"first6_num":1},{"first4_num":1,"insert_date":"2015-11-25 10:45:22","smooth_desc":"","smooth1":"3117","smooth3":"3074","smooth2":"1408","smooth5":"3143","smooth4":"3742","bad_rune":"精华：高级攻击力精华 x3\r\n印记：高级护甲穿透印记 x9\r\n符印：高级护甲符印 x9\r\n雕纹：高级冷却缩减雕纹 x9","smooth6":"3026","smooth_author":"ID豆子","smooth_rune":"精华：高级攻击力精华 x3\r\n印记：高级护甲穿透印记 x9\r\n符印：高级护甲符印 x9\r\n雕纹：高级冷却缩减雕纹 x9","id":1290,"bad_inborn":"12 0 18","bad6":"3083","bad5":"3742","bad4":"3190","bad3":"3143","bad2":"1408","bad1":"3047","smooth_inborn":"12 0 18","smooth_level":"超凡大师","first7_num":1,"bad_author":"ID豆子","add":"EWQQQR QEQERE EWWRWW","bad_desc":"","first1_num":1,"first5_num":1,"bad_level":"超凡大师","last_modify_date":"2017-03-01 17:47:07","first1":"1041","first2":"2031","first3":"3340","first4":"","first5":"","first6":"","first7":"","first3_num":1,"name":"打野打法","first2_num":1,"first6_num":1},{"first4_num":1,"insert_date":"2015-11-25 10:45:22","smooth_desc":"","smooth1":"3111","smooth3":"3742","smooth2":"3074","smooth5":"3143","smooth4":"3156","bad_rune":"精华：高级生命值精华 x3\r\n印记：高级护甲穿透印记 x9\r\n符印：高级护甲符印 x9\r\n雕纹：高级魔法抗性雕纹 x9","smooth6":"3742","smooth_author":"ID豆子","smooth_rune":"精华：高级生命值精华 x3\r\n印记：高级护甲穿透印记 x9\r\n符印：高级护甲符印 x9\r\n雕纹：高级魔法抗性雕纹 x9","id":1289,"bad_inborn":"12 0 18","bad6":"3143","bad5":"3068","bad4":"3102","bad3":"3143","bad2":"3074","bad1":"3111","smooth_inborn":"12 0 18","smooth_level":"超凡大师","first7_num":1,"bad_author":"ID豆子","add":"QEWWWR EWWQRQ QQEREE","bad_desc":"","first1_num":1,"first5_num":1,"bad_level":"超凡大师","last_modify_date":"2017-03-01 17:46:30","first1":"1011","first2":"1029","first3":"2003","first4":"","first5":"","first6":"","first7":"","first3_num":1,"name":"大乱斗打法","first2_num":1,"first6_num":1}]
     * ag_skill1 : 一记完全充能的【Q强能冲拳】会造成双倍伤害，如果你看到蔚开始蓄力了，你应该后撤，或者尝试躲掉它。
     */

    private String use_skill2;
    private String skill5_expend;
    private String opponent_reason1;
    private String skill3_cooling;
    private String color;
    private String skill5_damage;
    private boolean active;
    private String skill4_damage;
    private String skill3_add;
    private String use_skill3;
    private String skill5_cooling;
    private String skill4_expend;
    private String story;
    private String best_partner1;
    private String group;
    private String partner_reason1;
    private String skill5_add;
    private String skill2_expend;
    private String skill3;
    private String skill2;
    private String skill1;
    private String skill3_damage;
    private String skill3_expend;
    private String skill5;
    private String skill4;
    private String last_modify_date;
    private String teamwork;
    private int hero_id;
    private String discount_end_date;
    private String op_skill;
    private String use_skill1;
    private String insert_date;
    private String comment_info;
    private String discount_begin_date;
    private String skill2_add;
    private String skill4_cooling;
    private String best_partner2;
    private String newhero_end_date;
    private String skill3_desc;
    private String ag_skill3;
    private String skill5_desc;
    private String skill4_desc;
    private String skill4_add;
    private String skill2_cooling;
    private String skill2_damage;
    private String strongest_opponent1;
    private String strongest_opponent2;
    private String partner_reason2;
    private String newhero_begin_date;
    private String opponent_reason2;
    private String skill2_desc;
    private String ag_skill2;
    private String skill1_desc;
    private String ag_skill1;
    private List<PlayListBean> play_list;

    public String getUse_skill2() {
        return use_skill2;
    }

    public void setUse_skill2(String use_skill2) {
        this.use_skill2 = use_skill2;
    }

    public String getSkill5_expend() {
        return skill5_expend;
    }

    public void setSkill5_expend(String skill5_expend) {
        this.skill5_expend = skill5_expend;
    }

    public String getOpponent_reason1() {
        return opponent_reason1;
    }

    public void setOpponent_reason1(String opponent_reason1) {
        this.opponent_reason1 = opponent_reason1;
    }

    public String getSkill3_cooling() {
        return skill3_cooling;
    }

    public void setSkill3_cooling(String skill3_cooling) {
        this.skill3_cooling = skill3_cooling;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSkill5_damage() {
        return skill5_damage;
    }

    public void setSkill5_damage(String skill5_damage) {
        this.skill5_damage = skill5_damage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSkill4_damage() {
        return skill4_damage;
    }

    public void setSkill4_damage(String skill4_damage) {
        this.skill4_damage = skill4_damage;
    }

    public String getSkill3_add() {
        return skill3_add;
    }

    public void setSkill3_add(String skill3_add) {
        this.skill3_add = skill3_add;
    }

    public String getUse_skill3() {
        return use_skill3;
    }

    public void setUse_skill3(String use_skill3) {
        this.use_skill3 = use_skill3;
    }

    public String getSkill5_cooling() {
        return skill5_cooling;
    }

    public void setSkill5_cooling(String skill5_cooling) {
        this.skill5_cooling = skill5_cooling;
    }

    public String getSkill4_expend() {
        return skill4_expend;
    }

    public void setSkill4_expend(String skill4_expend) {
        this.skill4_expend = skill4_expend;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getBest_partner1() {
        return best_partner1;
    }

    public void setBest_partner1(String best_partner1) {
        this.best_partner1 = best_partner1;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPartner_reason1() {
        return partner_reason1;
    }

    public void setPartner_reason1(String partner_reason1) {
        this.partner_reason1 = partner_reason1;
    }

    public String getSkill5_add() {
        return skill5_add;
    }

    public void setSkill5_add(String skill5_add) {
        this.skill5_add = skill5_add;
    }

    public String getSkill2_expend() {
        return skill2_expend;
    }

    public void setSkill2_expend(String skill2_expend) {
        this.skill2_expend = skill2_expend;
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill3_damage() {
        return skill3_damage;
    }

    public void setSkill3_damage(String skill3_damage) {
        this.skill3_damage = skill3_damage;
    }

    public String getSkill3_expend() {
        return skill3_expend;
    }

    public void setSkill3_expend(String skill3_expend) {
        this.skill3_expend = skill3_expend;
    }

    public String getSkill5() {
        return skill5;
    }

    public void setSkill5(String skill5) {
        this.skill5 = skill5;
    }

    public String getSkill4() {
        return skill4;
    }

    public void setSkill4(String skill4) {
        this.skill4 = skill4;
    }

    public String getLast_modify_date() {
        return last_modify_date;
    }

    public void setLast_modify_date(String last_modify_date) {
        this.last_modify_date = last_modify_date;
    }

    public String getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(String teamwork) {
        this.teamwork = teamwork;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public String getDiscount_end_date() {
        return discount_end_date;
    }

    public void setDiscount_end_date(String discount_end_date) {
        this.discount_end_date = discount_end_date;
    }

    public String getOp_skill() {
        return op_skill;
    }

    public void setOp_skill(String op_skill) {
        this.op_skill = op_skill;
    }

    public String getUse_skill1() {
        return use_skill1;
    }

    public void setUse_skill1(String use_skill1) {
        this.use_skill1 = use_skill1;
    }

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }

    public String getComment_info() {
        return comment_info;
    }

    public void setComment_info(String comment_info) {
        this.comment_info = comment_info;
    }

    public String getDiscount_begin_date() {
        return discount_begin_date;
    }

    public void setDiscount_begin_date(String discount_begin_date) {
        this.discount_begin_date = discount_begin_date;
    }

    public String getSkill2_add() {
        return skill2_add;
    }

    public void setSkill2_add(String skill2_add) {
        this.skill2_add = skill2_add;
    }

    public String getSkill4_cooling() {
        return skill4_cooling;
    }

    public void setSkill4_cooling(String skill4_cooling) {
        this.skill4_cooling = skill4_cooling;
    }

    public String getBest_partner2() {
        return best_partner2;
    }

    public void setBest_partner2(String best_partner2) {
        this.best_partner2 = best_partner2;
    }

    public String getNewhero_end_date() {
        return newhero_end_date;
    }

    public void setNewhero_end_date(String newhero_end_date) {
        this.newhero_end_date = newhero_end_date;
    }

    public String getSkill3_desc() {
        return skill3_desc;
    }

    public void setSkill3_desc(String skill3_desc) {
        this.skill3_desc = skill3_desc;
    }

    public String getAg_skill3() {
        return ag_skill3;
    }

    public void setAg_skill3(String ag_skill3) {
        this.ag_skill3 = ag_skill3;
    }

    public String getSkill5_desc() {
        return skill5_desc;
    }

    public void setSkill5_desc(String skill5_desc) {
        this.skill5_desc = skill5_desc;
    }

    public String getSkill4_desc() {
        return skill4_desc;
    }

    public void setSkill4_desc(String skill4_desc) {
        this.skill4_desc = skill4_desc;
    }

    public String getSkill4_add() {
        return skill4_add;
    }

    public void setSkill4_add(String skill4_add) {
        this.skill4_add = skill4_add;
    }

    public String getSkill2_cooling() {
        return skill2_cooling;
    }

    public void setSkill2_cooling(String skill2_cooling) {
        this.skill2_cooling = skill2_cooling;
    }

    public String getSkill2_damage() {
        return skill2_damage;
    }

    public void setSkill2_damage(String skill2_damage) {
        this.skill2_damage = skill2_damage;
    }

    public String getStrongest_opponent1() {
        return strongest_opponent1;
    }

    public void setStrongest_opponent1(String strongest_opponent1) {
        this.strongest_opponent1 = strongest_opponent1;
    }

    public String getStrongest_opponent2() {
        return strongest_opponent2;
    }

    public void setStrongest_opponent2(String strongest_opponent2) {
        this.strongest_opponent2 = strongest_opponent2;
    }

    public String getPartner_reason2() {
        return partner_reason2;
    }

    public void setPartner_reason2(String partner_reason2) {
        this.partner_reason2 = partner_reason2;
    }

    public String getNewhero_begin_date() {
        return newhero_begin_date;
    }

    public void setNewhero_begin_date(String newhero_begin_date) {
        this.newhero_begin_date = newhero_begin_date;
    }

    public String getOpponent_reason2() {
        return opponent_reason2;
    }

    public void setOpponent_reason2(String opponent_reason2) {
        this.opponent_reason2 = opponent_reason2;
    }

    public String getSkill2_desc() {
        return skill2_desc;
    }

    public void setSkill2_desc(String skill2_desc) {
        this.skill2_desc = skill2_desc;
    }

    public String getAg_skill2() {
        return ag_skill2;
    }

    public void setAg_skill2(String ag_skill2) {
        this.ag_skill2 = ag_skill2;
    }

    public String getSkill1_desc() {
        return skill1_desc;
    }

    public void setSkill1_desc(String skill1_desc) {
        this.skill1_desc = skill1_desc;
    }

    public String getAg_skill1() {
        return ag_skill1;
    }

    public void setAg_skill1(String ag_skill1) {
        this.ag_skill1 = ag_skill1;
    }

    public List<PlayListBean> getPlay_list() {
        return play_list;
    }

    public void setPlay_list(List<PlayListBean> play_list) {
        this.play_list = play_list;
    }

    public static class PlayListBean {
        /**
         * first4_num : 1
         * insert_date : 2015-11-25 10:45:22
         * smooth_desc :
         * smooth1 : 3111
         * smooth3 : 3156
         * smooth2 : 3074
         * smooth5 : 3742
         * smooth4 : 3143
         * bad_rune : 精华：高级生命值精华 x3
         * 印记：高级护甲穿透印记 x9
         * 符印：高级护甲符印 x9
         * 雕纹：高级成长魔法抗性雕纹 x9
         * smooth6 : 3083
         * smooth_author : ID豆子
         * smooth_rune : 精华：高级生命值精华 x3
         * 印记：高级护甲穿透印记 x9
         * 符印：高级护甲符印 x9
         * 雕纹：高级成长魔法抗性雕纹 x9
         * id : 1291
         * bad_inborn : 12 0 18
         * bad6 : 3083
         * bad5 : 3742
         * bad4 : 3053
         * bad3 : 3143
         * bad2 : 3074
         * bad1 : 3111
         * smooth_inborn : 12 0 18
         * smooth_level : 超凡大师
         * first7_num : 1
         * bad_author : ID豆子
         * add : QEWWWR EWWQRQ QQEREE
         * bad_desc :
         * first1_num : 1
         * first5_num : 1
         * bad_level : 超凡大师
         * last_modify_date : 2017-03-01 17:47:19
         * first1 : 1054
         * first2 : 2003
         * first3 : 3340
         * first4 :
         * first5 :
         * first6 :
         * first7 :
         * first3_num : 1
         * name : 上单打法
         * first2_num : 1
         * first6_num : 1
         */

        private int first4_num;
        private String insert_date;
        private String smooth_desc;
        private String smooth1;
        private String smooth3;
        private String smooth2;
        private String smooth5;
        private String smooth4;
        private String bad_rune;
        private String smooth6;
        private String smooth_author;
        private String smooth_rune;
        @SerializedName("id")
        private int idX;
        private String bad_inborn;
        private String bad6;
        private String bad5;
        private String bad4;
        private String bad3;
        private String bad2;
        private String bad1;
        private String smooth_inborn;
        private String smooth_level;
        private int first7_num;
        private String bad_author;
        private String add;
        private String bad_desc;
        private int first1_num;
        private int first5_num;
        private String bad_level;
        private String last_modify_date;
        private String first1;
        private String first2;
        private String first3;
        private String first4;
        private String first5;
        private String first6;
        private String first7;
        private int first3_num;
        @SerializedName("name")
        private String nameX;
        private int first2_num;
        private int first6_num;

        public int getFirst4_num() {
            return first4_num;
        }

        public void setFirst4_num(int first4_num) {
            this.first4_num = first4_num;
        }

        public String getInsert_date() {
            return insert_date;
        }

        public void setInsert_date(String insert_date) {
            this.insert_date = insert_date;
        }

        public String getSmooth_desc() {
            return smooth_desc;
        }

        public void setSmooth_desc(String smooth_desc) {
            this.smooth_desc = smooth_desc;
        }

        public String getSmooth1() {
            return smooth1;
        }

        public void setSmooth1(String smooth1) {
            this.smooth1 = smooth1;
        }

        public String getSmooth3() {
            return smooth3;
        }

        public void setSmooth3(String smooth3) {
            this.smooth3 = smooth3;
        }

        public String getSmooth2() {
            return smooth2;
        }

        public void setSmooth2(String smooth2) {
            this.smooth2 = smooth2;
        }

        public String getSmooth5() {
            return smooth5;
        }

        public void setSmooth5(String smooth5) {
            this.smooth5 = smooth5;
        }

        public String getSmooth4() {
            return smooth4;
        }

        public void setSmooth4(String smooth4) {
            this.smooth4 = smooth4;
        }

        public String getBad_rune() {
            return bad_rune;
        }

        public void setBad_rune(String bad_rune) {
            this.bad_rune = bad_rune;
        }

        public String getSmooth6() {
            return smooth6;
        }

        public void setSmooth6(String smooth6) {
            this.smooth6 = smooth6;
        }

        public String getSmooth_author() {
            return smooth_author;
        }

        public void setSmooth_author(String smooth_author) {
            this.smooth_author = smooth_author;
        }

        public String getSmooth_rune() {
            return smooth_rune;
        }

        public void setSmooth_rune(String smooth_rune) {
            this.smooth_rune = smooth_rune;
        }

        public int getIdX() {
            return idX;
        }

        public void setIdX(int idX) {
            this.idX = idX;
        }

        public String getBad_inborn() {
            return bad_inborn;
        }

        public void setBad_inborn(String bad_inborn) {
            this.bad_inborn = bad_inborn;
        }

        public String getBad6() {
            return bad6;
        }

        public void setBad6(String bad6) {
            this.bad6 = bad6;
        }

        public String getBad5() {
            return bad5;
        }

        public void setBad5(String bad5) {
            this.bad5 = bad5;
        }

        public String getBad4() {
            return bad4;
        }

        public void setBad4(String bad4) {
            this.bad4 = bad4;
        }

        public String getBad3() {
            return bad3;
        }

        public void setBad3(String bad3) {
            this.bad3 = bad3;
        }

        public String getBad2() {
            return bad2;
        }

        public void setBad2(String bad2) {
            this.bad2 = bad2;
        }

        public String getBad1() {
            return bad1;
        }

        public void setBad1(String bad1) {
            this.bad1 = bad1;
        }

        public String getSmooth_inborn() {
            return smooth_inborn;
        }

        public void setSmooth_inborn(String smooth_inborn) {
            this.smooth_inborn = smooth_inborn;
        }

        public String getSmooth_level() {
            return smooth_level;
        }

        public void setSmooth_level(String smooth_level) {
            this.smooth_level = smooth_level;
        }

        public int getFirst7_num() {
            return first7_num;
        }

        public void setFirst7_num(int first7_num) {
            this.first7_num = first7_num;
        }

        public String getBad_author() {
            return bad_author;
        }

        public void setBad_author(String bad_author) {
            this.bad_author = bad_author;
        }

        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }

        public String getBad_desc() {
            return bad_desc;
        }

        public void setBad_desc(String bad_desc) {
            this.bad_desc = bad_desc;
        }

        public int getFirst1_num() {
            return first1_num;
        }

        public void setFirst1_num(int first1_num) {
            this.first1_num = first1_num;
        }

        public int getFirst5_num() {
            return first5_num;
        }

        public void setFirst5_num(int first5_num) {
            this.first5_num = first5_num;
        }

        public String getBad_level() {
            return bad_level;
        }

        public void setBad_level(String bad_level) {
            this.bad_level = bad_level;
        }

        public String getLast_modify_date() {
            return last_modify_date;
        }

        public void setLast_modify_date(String last_modify_date) {
            this.last_modify_date = last_modify_date;
        }

        public String getFirst1() {
            return first1;
        }

        public void setFirst1(String first1) {
            this.first1 = first1;
        }

        public String getFirst2() {
            return first2;
        }

        public void setFirst2(String first2) {
            this.first2 = first2;
        }

        public String getFirst3() {
            return first3;
        }

        public void setFirst3(String first3) {
            this.first3 = first3;
        }

        public String getFirst4() {
            return first4;
        }

        public void setFirst4(String first4) {
            this.first4 = first4;
        }

        public String getFirst5() {
            return first5;
        }

        public void setFirst5(String first5) {
            this.first5 = first5;
        }

        public String getFirst6() {
            return first6;
        }

        public void setFirst6(String first6) {
            this.first6 = first6;
        }

        public String getFirst7() {
            return first7;
        }

        public void setFirst7(String first7) {
            this.first7 = first7;
        }

        public int getFirst3_num() {
            return first3_num;
        }

        public void setFirst3_num(int first3_num) {
            this.first3_num = first3_num;
        }

        public String getNameX() {
            return nameX;
        }

        public void setNameX(String nameX) {
            this.nameX = nameX;
        }

        public int getFirst2_num() {
            return first2_num;
        }

        public void setFirst2_num(int first2_num) {
            this.first2_num = first2_num;
        }

        public int getFirst6_num() {
            return first6_num;
        }

        public void setFirst6_num(int first6_num) {
            this.first6_num = first6_num;
        }
    }
}
