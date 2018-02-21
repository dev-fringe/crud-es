package dev.fringe.crud.controller

import dev.fringe.crud.service.CrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}

@Controller class HomeController @Autowired()(service:CrudService) {
  @RequestMapping(Array("/")) def get(): String = "index"
  @RequestMapping(Array("/test")) @ResponseBody def get1(): String = "index"
}
