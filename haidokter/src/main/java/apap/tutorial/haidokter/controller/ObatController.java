package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ObatController {
    @Qualifier("resepServiceImpl")
    @Autowired
    ResepService resepService;

    @Autowired
    ObatService obatService;

    @GetMapping("/obat/add/{noResep}")
    private String addObatFormPage(
            @PathVariable Long noResep,
            Model model
    ){
        ObatModel obat = new ObatModel();
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        obat.setResepModel(resep);
        model.addAttribute("obat", obat);

        return "form-add-obat";

    }

    @PostMapping("obat/add")
    private String addObatSubmit(
            @ModelAttribute ObatModel obat,
            Model model
    ){
        obatService.addObat(obat);
        model.addAttribute("noResep",obat.getResepModel().getNoResep());
        model.addAttribute("obat", obat);

        return "add-obat";
    }

    @GetMapping("/obat/change/{id}")
    private String changeObatFormPage(
            @PathVariable Long id,
            Model model){
        ObatModel obat = obatService.getObatById(id);
        model.addAttribute("obat", obat);

        return "form-update-obat";
    }

    @PostMapping("/obat/change")
    private String changeObatFormSubmit(
            @ModelAttribute ObatModel obat,
            Model model){
        ObatModel obatModel = obatService.changeObat(obat);
        model.addAttribute("id", obat.getId());
        return "update-obat";
    }

//    @GetMapping("/obat/delete/{id}")
//    private String deleteObat(
//            @PathVariable Long id,
//            Model model){
//        ObatModel obat = obatService.getObatById(id);
//        model.addAttribute("obat", obat);
//        obatService.deleteObat(obat);
//        return "delete-obat";
//    }

    @PostMapping(value = "/obat/delete")
    public String deleteMenuFormSubmit(@ModelAttribute ResepModel resep, Model model){
        model.addAttribute("obatCount", resep.getListObat().size());
        for (ObatModel obat : resep.getListObat()){
            obatService.deleteObatById(obat.getId());
        }
        return "delete-obat";
    }

    @GetMapping("/obat/add-multiple/{noResep}")
    private String addObatMultiple(
            @PathVariable Long noResep,
            Model model
    ){
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        List<ObatModel> listObat = new ArrayList<ObatModel>();

        resep.setListObat(listObat);
        resep.getListObat().add(new ObatModel());
        model.addAttribute("resep", resep);

        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/{noResep}", params = {"save"})
    private String addObatMultipleSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ){
        for(int i = 0; i<resep.getListObat().size(); i++){
            resep.getListObat().get(i).setResepModel(resep);
            obatService.addObat(resep.getListObat().get(i));
        }
        model.addAttribute("obatCount", resep.getListObat().size());
        model.addAttribute("listObat", resep.getListObat());
        return "add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/{noResep}", params = {"addRow"})
    private String addRowObatMultiple(
            @ModelAttribute ResepModel resep,
            Model model
    ){
        if(resep.getListObat() == null || resep.getListObat().size() == 0){
            resep.setListObat(new ArrayList<ObatModel>());
        }
        resep.getListObat().add(new ObatModel());
        model.addAttribute("resep", resep);

        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple/{noResep}", params = {"deleteRow"})
    private String deleteRowObatMultiple(
            @ModelAttribute ResepModel resep,
            final HttpServletRequest req,
            Model model
    ){
        final Integer rowId = Integer.valueOf(req.getParameter("deleteRow"));
        resep.getListObat().remove(rowId.intValue());

        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

}