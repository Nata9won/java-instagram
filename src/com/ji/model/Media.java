package com.ji.model;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.ji.exception.InstagramException;

/**
 * 
 * @author Abhijeet Iraj
 * 
 */
public class Media
{
    private String attribution;
    private List<String> tags;
    private String type;
    private Location location;
    private Comments comments;
    private String filter;
    private String createdTime;
    private String link;
    private Likes likes;
    private Image image;
    private Caption caption;
    private boolean userHasLiked;
    private String id;
    private User user;

    public String getAttribution()
    {
        return attribution;
    }

    public void setAttribution(String attribution)
    {
        this.attribution = attribution;
    }

    public List<String> getTags()
    {
        return tags;
    }

    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public Comments getComments()
    {
        return comments;
    }

    public void setComments(Comments comments)
    {
        this.comments = comments;
    }

    public String getFilter()
    {
        return filter;
    }

    public void setFilter(String filter)
    {
        this.filter = filter;
    }

    public String getCreatedTime()
    {
        return createdTime;
    }

    public void setCreatedTime(String createdTime)
    {
        this.createdTime = createdTime;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public Likes getLikes()
    {
        return likes;
    }

    public void setLikes(Likes likes)
    {
        this.likes = likes;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public Caption getCaption()
    {
        return caption;
    }

    public void setCaption(Caption caption)
    {
        this.caption = caption;
    }

    public boolean isUserHasLiked()
    {
        return userHasLiked;
    }

    public void setUserHasLiked(boolean userHasLiked)
    {
        this.userHasLiked = userHasLiked;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Media [attribution=" + attribution + ", tags=" + tags + ", type=" + type + ", location=" + location + ", comments=" + comments
                + ", filter=" + filter + ", createdTime=" + createdTime + ", link=" + link + ", likes=" + likes + ", image=" + image + ", caption="
                + caption + ", userHasLiked=" + userHasLiked + ", id=" + id + ", user=" + user + "]";
    }

    public Media deserialize(JSONObject media) throws InstagramException
    {
        try
        {
            setType(media.getString("type"));
            setLink(media.getString("link"));
            //Get standard resolution
            JSONObject imageData = new JSONObject(media.getString("images"));
            imageData = new JSONObject(imageData.getString("standard_resolution"));
            Image image_t = new Image();
            image_t.setUrl(imageData.getString("url"));
            setImage(image_t);
            
        }
        catch (JSONException e)
        {
            throw new InstagramException(e);
        }
        
        return this;
    }
}
