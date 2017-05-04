package BuilderPattern;

/**
 * Created by lovejoy on 04/05/2017.
 */
class Actor {
    private String type;
    private String sex;
    private String face;
    private String costume;
    private String hairstyle;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    public String getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(String hairstyle) {
        this.hairstyle = hairstyle;
    }
}

abstract class ActorBuilder {
    Actor actor = new Actor();

    abstract void buildType();

    abstract void buildSex();

    abstract void buildFace();

    abstract void buildCostume();

    abstract void buildHairstyle();

    public Actor createActor() {
        return actor;
    }
}

class HeroBuilder extends ActorBuilder {
    void buildType() {
        actor.setType("Hero");
    }

    void buildSex() {
        actor.setSex("Male");
    }

    void buildFace() {
        actor.setFace("Handsome");
    }

    void buildCostume() {
        actor.setCostume("Armor");
    }

    void buildHairstyle() {
        actor.setHairstyle("Short Hair");
    }
}

class AngelBuilder extends ActorBuilder {
    void buildType() {
        actor.setType("Angel");
    }

    void buildSex() {
        actor.setSex("Female");
    }

    void buildFace() {
        actor.setFace("Beautiful");
    }

    void buildCostume() {
        actor.setCostume("Dress");
    }

    void buildHairstyle() {
        actor.setHairstyle("Long Hair");
    }
}

class ActorController {
    public Actor constract(ActorBuilder actorBuilder) {
        Actor actor;
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        actorBuilder.buildHairstyle();
        actor = actorBuilder.createActor();
        return actor;
    }
}

class Client {
    public static void main(String args[]){
        ActorBuilder actorBuilder = new HeroBuilder();

        ActorController actorController = new ActorController();

        Actor actor = actorController.constract(actorBuilder);

        System.out.println("Type: "+actor.getType());
    }
}