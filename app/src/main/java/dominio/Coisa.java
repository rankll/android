package dominio;

import java.io.Serializable;

/**
 * Created by helio on 05/05/15.
 */
public class Coisa implements Serializable {

    private String _id;
    private String name;
    private String description;
    private ThingType thingType;

    private String[] tags;

    private int position;

    public Coisa() {
    }

    public Coisa(String id, String name, String description, String[] tags) {

        this._id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public Coisa(String id, String name, String description, int position) {
        this._id = id;
        this.name = name;
        this.description = description;
        this.position = position;
    }

    public Coisa(String id, String name, String description) {
        this._id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ThingType getThingType() {
        return thingType;
    }

    public void setThingType(ThingType thingType) {
        this.thingType = thingType;
    }

    @Override
    public String toString(){
        return this.getName() + " / " + this.getDescription();
    }
}
