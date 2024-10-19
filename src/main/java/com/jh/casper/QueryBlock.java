package com.jh.casper;

import java.io.IOException;
import com.casper.sdk.service.CasperService;
import com.casper.sdk.identifier.block.HashBlockIdentifier;
import com.casper.sdk.identifier.block.HeightBlockIdentifier;
import com.casper.sdk.model.block.ChainGetBlockResult;
import com.casper.sdk.model.block.JsonBlockData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class QueryBlock {

    public static void main(String[] args) throws IOException {
        System.out.println("== start ==");

        final CasperService casperService = CasperService.usingPeer("3.14.48.188", 7777);
        // //recent block
        // final ChainGetBlockResult result = casperService.getBlock();

        // // by block height
        // final ChainGetBlockResult result = casperService.getBlock(new
        // HeightBlockIdentifier(3329412));
        // ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        // by block hash
        ChainGetBlockResult result = casperService
                .getBlock(new HashBlockIdentifier("5438ea5f003d3d2b2b0a7b59aa54f79761ac5eb0f10f8585cd79a7bb86367cc9"));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(result);
        System.out.println(json);

        System.out.println("== end ==");
    }
}

// devnet ips()
// 3.14.48.188
// 3.139.219.212
// 18.218.51.191
// 3.20.57.210