package com.meli.linktracker.controllers;

import com.meli.linktracker.dtos.LinkDTO;
import com.meli.linktracker.dtos.ResponseErrorDTO;
import com.meli.linktracker.exceptions.LinkInvalid;
import com.meli.linktracker.exceptions.LinkNotCreated;
import com.meli.linktracker.exceptions.LinkNotFound;
import com.meli.linktracker.exceptions.LinkUnAuthorized;
import com.meli.linktracker.services.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class LinkTrackerController {
    @Autowired
    private LinkTrackerService linkService;
    //________________ GETS ________________
    @GetMapping("/list")
    public ResponseEntity<List<LinkDTO>> getLinks() throws FileNotFoundException {
        return new ResponseEntity<List<LinkDTO>>(linkService.getLinks(),HttpStatus.OK);
    }
    @GetMapping("/metrics/{ref}")
    public ResponseEntity<LinkDTO> getLinkPorReferencia(@PathVariable int ref) throws FileNotFoundException, LinkNotFound {
        return new ResponseEntity<>(linkService.getLinkByRef(ref),HttpStatus.OK);
    }
    @GetMapping("/link/{ref}")
    public RedirectView redireccionarLinkPorReferencia(@PathVariable int ref) throws FileNotFoundException, LinkNotFound, LinkInvalid, LinkUnAuthorized {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://"+linkService.redirectLinkByRef(ref,"").getUrl());
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }
    @GetMapping("/link/{ref}/{pwd}")
    public RedirectView redireccionarLinkPorReferencia(@PathVariable int ref,@PathVariable String pwd) throws FileNotFoundException, LinkNotFound, LinkInvalid, LinkUnAuthorized {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://"+linkService.redirectLinkByRef(ref,pwd).getUrl());
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }

    //________________ POSTS ________________
    @PostMapping("/create")
    public ResponseEntity<LinkDTO> crearLink(@RequestBody LinkDTO link) throws FileNotFoundException, LinkNotCreated {
        return new ResponseEntity<>(linkService.crearLink(link), HttpStatus.CREATED);
    }
    @PostMapping("/invalidate/{ref}")
    public ResponseEntity<LinkDTO> invalidarLink(@PathVariable int ref) throws FileNotFoundException, LinkNotCreated, LinkNotFound {
        return new ResponseEntity<>(linkService.invalidarLink(ref), HttpStatus.OK);
    }

    //_______________ Exceptions _____________________
    @ExceptionHandler(LinkNotFound.class)
    public ResponseEntity<ResponseErrorDTO> linkNotFoundException(LinkNotFound errorException){
        ResponseErrorDTO errorDTO= new ResponseErrorDTO();
        errorDTO.setNombre("Link no encontrado.");
        errorDTO.setMensaje("El link " + errorException.getMessage()+" no fue encontrado.");
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LinkNotCreated.class)
    public ResponseEntity<ResponseErrorDTO> linkNotCreatedException(LinkNotCreated errorException){
        ResponseErrorDTO errorDTO= new ResponseErrorDTO();
        errorDTO.setNombre("Link no creado.");
        errorDTO.setMensaje("El link " + errorException.getMessage()+" no fue creado.");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LinkInvalid.class)
    public ResponseEntity<ResponseErrorDTO> linkInvalidException(LinkInvalid errorException){
        ResponseErrorDTO errorDTO= new ResponseErrorDTO();
        errorDTO.setNombre("Link invalido.");
        errorDTO.setMensaje("El link " + errorException.getMessage()+" fue invalidado.");
        return new ResponseEntity<>(errorDTO, HttpStatus.LOCKED);
    }
    @ExceptionHandler(LinkUnAuthorized.class)
    public ResponseEntity<ResponseErrorDTO> linkUnAuthorizedxception(LinkUnAuthorized errorException){
        ResponseErrorDTO errorDTO= new ResponseErrorDTO();
        errorDTO.setNombre("Link no autorizado.");
        errorDTO.setMensaje("El link " + errorException.getMessage()+" no ha sido autorizado, fallo de autenticacion.");
        return new ResponseEntity<>(errorDTO, HttpStatus.UNAUTHORIZED);
    }
}
