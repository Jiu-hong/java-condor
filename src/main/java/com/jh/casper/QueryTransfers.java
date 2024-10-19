package com.jh.casper;

import java.io.IOException;
import com.casper.sdk.service.CasperService;
import com.casper.sdk.identifier.block.HashBlockIdentifier;
import com.casper.sdk.identifier.block.HeightBlockIdentifier;
import com.casper.sdk.model.block.ChainGetBlockResult;
import com.casper.sdk.model.block.JsonBlockData;
import com.casper.sdk.model.peer.PeerData;
import com.casper.sdk.model.transfer.TransferData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class QueryTransfers {

    public static void main(String[] args) throws IOException {
        System.out.println("== start ==");

        final CasperService casperService = CasperService.usingPeer("3.14.48.188", 7777);

        // // Last block
        // final TransferData transferData = casperService.getBlockTransfers();

        // By block height
        TransferData transferData = casperService.getBlockTransfers(new HeightBlockIdentifier(3335394));

        // // By block hash
        // TransferData transferData = casperService.getBlockTransfers(
        // new
        // HashBlockIdentifier("6e28cf351ba963e0db69c77b58dac3e584b9053ecf974c000cabbd069ddc79cd"));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(transferData);
        System.out.println(json);

        System.out.println("== end ==");
    }
}

// devnet ips()
// 3.14.48.188
// 3.139.219.212
// 18.218.51.191
// 3.20.57.210