package com.jh.casper;

import java.io.IOException;

import com.casper.sdk.model.transaction.GetTransactionResult;
import com.casper.sdk.model.transaction.TransactionHashDeploy;
import com.casper.sdk.service.CasperService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

// NG
public class QueryTransaction {
    public static void main(String[] args) throws IOException {
        System.out.println("== start ==");

        final CasperService casperService = CasperService.usingPeer("3.139.219.212", 7777);
        GetTransactionResult transactionResult = casperService.getTransaction(
                new TransactionHashDeploy("8b4095647471b9cdef324d0c2a2be2e8119ff3efbd80525050ddd73d29565a54"));
        // ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        // String json = ow.writeValueAsString(transactionResult);
        // System.out.println(json);

        System.out.println("== end ==");
    }
}
