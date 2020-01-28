package main.java.bfm.farmer;


import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

/**
 * Demo program to deposit a helloworld smart contract in the blockchain using geth via web3j access.
 * Geth must powered up and mining, first:
 geth --datadir="elephantchain" --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 * [*] runs the silent miner for an uninvolved third account.
 * [*] operates on the elephant chain
 */
public class Deployer
{
    // Path to ethereum base dir (This account will be debited)
    private final String LOCATION_SOURCE_ACCOUNT = "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T13-20-56.406226000Z--b1020b2231eacf6ec05fb262630d8b9875d35b08";

    // Password of the source account
    private final String SOURCE_ACCOUNT_PASSWORD = "root";
    private final String COWBREEDER_ACCOUNT = "0xd88032ecCE65381e798503D56Ad15Db456C26Adf";
    private final BigInteger GOAL_AMOUNT = BigInteger.valueOf(50000);
    private final BigInteger MILK_PRICE = BigInteger.valueOf(5);
    private final BigInteger DURATION = BigInteger.valueOf(900);


    private final String INVESTOR_ACCOUNT_1 = "0xd88032ecCE65381e798503D56Ad15Db456C26Adf";


    public Farminginvestment transferContract () throws Exception {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentials = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

        // Deploy the contract in the blockchain
        return Farminginvestment.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT, COWBREEDER_ACCOUNT, GOAL_AMOUNT, MILK_PRICE, DURATION).send();

        }

    public Farminginvestment getContract () throws Exception {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentials = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

        // Deploy the contract in the blockchain
        return Farminginvestment.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT, COWBREEDER_ACCOUNT, GOAL_AMOUNT, MILK_PRICE, DURATION).send();

    }
}


