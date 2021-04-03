package com.meli.linktracker.services;

import com.meli.linktracker.dtos.LinkDTO;
import com.meli.linktracker.exceptions.LinkInvalid;
import com.meli.linktracker.exceptions.LinkNotCreated;
import com.meli.linktracker.exceptions.LinkNotFound;
import com.meli.linktracker.exceptions.LinkUnAuthorized;
import com.meli.linktracker.repositories.LinkRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class LinkTrackerService {
    @Autowired
    private LinkRepositoryImpl linkRepository;
    public LinkDTO crearLink(LinkDTO link) throws FileNotFoundException, LinkNotCreated {
        link.setID(linkRepository.getBiblioteca());
        linkRepository.crearLink(link);
        return link;
    }
    public List<LinkDTO> getLinks() throws FileNotFoundException {
        return linkRepository.getBiblioteca().getLinks();
    }

    public LinkDTO getLinkByIndex(int index) throws FileNotFoundException, LinkNotFound {
        return linkRepository.encontrarLinkPorIndex(index);
    }

    public LinkDTO getLinkByRef(int ref) throws FileNotFoundException, LinkNotFound {
        return linkRepository.encontrarLinkPorReferencia(ref);
    }

    public LinkDTO invalidarLink(int ref) throws FileNotFoundException, LinkNotFound {
        return linkRepository.invalidarLinkPorReferencia(ref);
    }

    public LinkDTO redirectLinkByRef(int ref, String pwd) throws FileNotFoundException, LinkNotFound, LinkInvalid, LinkUnAuthorized {
        return linkRepository.incrementarLinkPorReferencia(ref,pwd);
    }
}
