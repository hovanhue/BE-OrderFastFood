package com.example.hue.controllers;

import com.example.hue.common.response.MessageResponse;
import com.example.hue.services.PayPalService;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pay")
public class PaypalController {

    @Autowired
    PayPalService payPalService;

    public static final String SUCCESS_URL = "/success";
    public static final String CANCEL_URL = "/cancel";

    @GetMapping(value = CANCEL_URL)
    public ResponseEntity cancelPay() {
        return ResponseEntity
                .ok()
                .body(new MessageResponse("Success: Cancel payment successful!"));
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

}
