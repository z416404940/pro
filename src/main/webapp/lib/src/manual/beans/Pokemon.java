package manual.beans;

/**
 * @author 郑文斌Mz
 * @version 1.0.0
 * @date 2019/12/269:58
 * @copyright &copy; <a href="http://www.xuetang9.com">老九学堂</a> 版权所有
 * @address 成都市西部国际金融中心2栋2201老九学堂
 */
public class Pokemon {
    private Integer id;
    private String icon;
    private String name;
    private String name_en;
    private String name_jp;
    private String type;
    private String egg_group;
    private String ability;
    private String ability_hidden;
    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer spatk;
    private Integer spdef;
    private Integer spd;

    public Pokemon() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_jp() {
        return name_jp;
    }

    public void setName_jp(String name_jp) {
        this.name_jp = name_jp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEgg_group() {
        return egg_group;
    }

    public void setEgg_group(String egg_group) {
        this.egg_group = egg_group;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getAbility_hidden() {
        return ability_hidden;
    }

    public void setAbility_hidden(String ability_hidden) {
        this.ability_hidden = ability_hidden;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getSpatk() {
        return spatk;
    }

    public void setSpatk(Integer spatk) {
        this.spatk = spatk;
    }

    public Integer getSpdef() {
        return spdef;
    }

    public void setSpdef(Integer spdef) {
        this.spdef = spdef;
    }

    public Integer getSpd() {
        return spd;
    }

    public void setSpd(Integer spd) {
        this.spd = spd;
    }
}
