package it.aulab.progetto_blog.utils.mappings;

import org.modelmapper.PropertyMap;

import it.aulab.progetto_blog.dtos.AuthorDto;
import it.aulab.progetto_blog.models.Author;

public class AuthorToAuthorDtoPropertyMap extends PropertyMap<Author, AuthorDto>{

    @Override
    protected void configure() {
        //map().setFullname(source.getFullname()); // vedere se funge
        map(source.getFullname()).setFullname(null);
        using(new CollectionToIntegerConverter()).map(source.getPosts()).setNumberOfPosts(null);
        // map(source.getImages()).setImages(null);
    }
    
}
