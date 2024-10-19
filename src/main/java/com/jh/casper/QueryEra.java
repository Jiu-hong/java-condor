package com.jh.casper;

import java.io.IOException;
import com.casper.sdk.service.CasperService;
import com.casper.sdk.identifier.block.HashBlockIdentifier;
import com.casper.sdk.identifier.block.HeightBlockIdentifier;
import com.casper.sdk.model.block.ChainGetBlockResult;
import com.casper.sdk.model.block.JsonBlockData;
import com.casper.sdk.model.era.EraInfoData;
import com.casper.sdk.model.peer.PeerData;
import com.casper.sdk.model.transfer.TransferData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class QueryEra {

    public static void main(String[] args) throws IOException {
        System.out.println("== start ==");

        final CasperService casperService = CasperService.usingPeer("3.139.219.212", 7777);

        // // By block height
        // EraInfoData eraInfoData = casperService.getEraSummary(new
        // HeightBlockIdentifier(3329276));

        // By block hash
        EraInfoData eraInfoData = casperService.getEraSummary(
                new HashBlockIdentifier("22ac7c324fe68311a7a3bb194dc6c92b6aa4b5d8639e1c747439f33584de2b1b"));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(eraInfoData);
        System.out.println(json);

        System.out.println("== end ==");
    }
}

// devnet ips()
// 3.14.48.188
// 3.139.219.212
// 18.218.51.191
// 3.20.57.210