package com.meli.linktracker.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.linktracker.dtos.BibliotecaLinksDTO;
import com.meli.linktracker.dtos.LinkDTO;
import com.meli.linktracker.exceptions.LinkInvalid;
import com.meli.linktracker.exceptions.LinkNotCreated;
import com.meli.linktracker.exceptions.LinkNotFound;
import com.meli.linktracker.exceptions.LinkUnAuthorized;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.*;
import java.io.*;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    BibliotecaLinksDTO biblioteca=null;
    List<LinkDTO> links=null;
    LinkDTO link = null;
    public LinkDTO encontrarLinkPorUrl(String url) throws LinkNotFound, FileNotFoundException {
        links = cargarBiblioteca().getLinks();
        if(links==null)
            return null;
        LinkDTO result = null;
        Optional<LinkDTO> item = links.stream()
                .filter(LinkDTO -> LinkDTO.getUrl().equals(url))
                .findFirst();
        if (item.isPresent())
            result = item.get();
        else
            throw new LinkNotFound(String.valueOf(url));
        return result;
    }
    public LinkDTO encontrarLinkPorReferencia(int ref) throws LinkNotFound, FileNotFoundException {
        links = cargarBiblioteca().getLinks();
        if(links==null)
            return null;
        LinkDTO result = null;
        Optional<LinkDTO> item = links.stream()
                .filter(LinkDTO -> LinkDTO.getRef()==ref)
                .findFirst();
        if (item.isPresent())
            result = item.get();
        else
            throw new LinkNotFound(String.valueOf(ref));
        return result;
    }
    public LinkDTO encontrarLinkPorIndex(int index) throws LinkNotFound, FileNotFoundException {
        links = cargarBiblioteca().getLinks();
        if(links==null)
            return null;
        if(index<0 || index>=links.size())
            throw new LinkNotFound(String.valueOf(index));
        else
            return links.get(index);
    }
    private BibliotecaLinksDTO cargarBiblioteca() throws FileNotFoundException {
        File file = null;
        try {
            file = ResourceUtils.getFile("direcciones.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<BibliotecaLinksDTO> typeRef = new TypeReference<BibliotecaLinksDTO>() {};
        BibliotecaLinksDTO biblioteca = null;
        try {
            biblioteca = objectMapper.readValue(file, typeRef);
        }catch (Exception e){
            e.printStackTrace();
        }
        return biblioteca;
    }
    private boolean guardarLinksJson(BibliotecaLinksDTO biblioteca) throws FileNotFoundException {
        File file = null;
        try {
            file = ResourceUtils.getFile("direcciones.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if(biblioteca!=null)
                objectMapper.writeValue(file, biblioteca);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean crearLink(LinkDTO link) throws FileNotFoundException, LinkNotCreated {
        biblioteca=cargarBiblioteca();
        if(biblioteca.getLinks()!=null){
            biblioteca.getLinks().add(link);
            biblioteca.setReferencia(biblioteca.getReferencia()+1);
            guardarLinksJson(biblioteca);
            return true;
        }else{
            throw new LinkNotCreated(link.getUrl());
        }
    }
    public LinkDTO invalidarLinkPorReferencia(int ref) throws FileNotFoundException, LinkNotFound {
        biblioteca=cargarBiblioteca();
        link = encontrarLinkPorReferencia(ref);
        link.setEstado(false);
        biblioteca.setLinks(links);
        guardarLinksJson(biblioteca);
        return encontrarLinkPorReferencia(ref);
    }
    public LinkDTO incrementarLinkPorReferencia(int ref,String pwd) throws FileNotFoundException, LinkNotFound, LinkInvalid, LinkUnAuthorized {
        biblioteca=cargarBiblioteca();
        link = encontrarLinkPorReferencia(ref);
        if(link.getEstado()){
            if(link.autorizar(pwd)){
                link.incrementar();
                biblioteca.setLinks(links);
                guardarLinksJson(biblioteca);
                return encontrarLinkPorReferencia(ref);
            }else {
                throw new LinkUnAuthorized(String.valueOf(ref));
            }
        }else
            throw new LinkInvalid(String.valueOf(ref));
    }
    public BibliotecaLinksDTO getBiblioteca() throws FileNotFoundException {
        return cargarBiblioteca();
    }
}
