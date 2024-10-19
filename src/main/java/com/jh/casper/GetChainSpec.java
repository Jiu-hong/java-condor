package com.jh.casper;

import java.io.IOException;

import com.casper.sdk.model.status.ChainspecData;
import com.casper.sdk.service.CasperService;

public class GetChainSpec {
    public static void main(String[] args) throws IOException {
        System.out.println("== start ==");

        CasperService casperService = CasperService.usingPeer("3.139.219.212", 7777);

        ChainspecData chainspec = casperService.getChainspec();

        System.out.println(chainspec.readChainspecBytesToString());
        System.out.println("== end ==");
    }
}
