package com.aca.mtgprice.controller;

import com.aca.mtgprice.model.CardType;
import com.aca.mtgprice.model.MtgPrice;
import com.aca.mtgprice.model.PriceException;
import com.aca.mtgprice.service.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "api/cards", produces = "application/json")
@CrossOrigin("http://127.0.0.1:5500")


public class PriceController {
    private final PriceService service = new PriceService();


}
