package main.java.bfm.farmer;


import main.java.bfm.farmer.Launcher.USERS.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
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

    // Password of the source account
    private final BigInteger GOAL_AMOUNT = BigInteger.valueOf(50000);
    private final BigInteger MILK_PRICE = BigInteger.valueOf(5);
    private final BigInteger DURATION = BigInteger.valueOf(900);

    public class User{
        public String location_source_account;
        public String account;
        public String account_pwd;
        public User(){}
        public User(String _location_source_account, String _account, String _account_pwd ){
            location_source_account = _location_source_account;
            account = _account;
            account_pwd = _account_pwd;
        }
    }

    private final User FARMER = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T13-20-56.406226000Z--b1020b2231eacf6ec05fb262630d8b9875d35b08",
            "0xb1020b2231eacf6ec05fb262630d8b9875d35b08",
            "root"
    );

    private final User INVESTOR_1 = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T10-18-34.296735000Z--d61c41f105c06c4e9558599d5b4df1faf05deac7",
            "0xUTC--2020-01-28T10-18-34.296735000Z--d61c41f105c06c4e9558599d5b4df1faf05deac7",
            "farmerpwd"
    );

    private final User INVESTOR_2 = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T10-19-02.147516000Z--2657df43346f9dfe71aa0e58dc0c58b16d9a1dd5",
            "0x2657df43346f9dfe71aa0e58dc0c58b16d9a1dd5",
            "farmerpwd"
    );

    private final User CLIENT = new User(
            "TODO",
            "TODO",
            "root"
    );

    private final User COWBREEDER = new User(
            "/Users/mariefrance/Library/Ethereum/farmerchain/keystore/UTC--2020-01-28T10-17-21.419239000Z--d88032ecce65381e798503d56ad15db456c26adf",
            "0xd88032ecCE65381e798503D56Ad15Db456C26Adf",
            "farmerpwd"
    );



    public Farminginvestment transferContract (int _duration, int _goalAmount, int _milkPrice) throws Exception {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentials = WalletUtils.loadCredentials(FARMER.account_pwd, FARMER.location_source_account);

        // Deploy the contract in the blockchain
        return Farminginvestment.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT,
                COWBREEDER.account,
                BigInteger.valueOf(_goalAmount), BigInteger.valueOf(_milkPrice), BigInteger.valueOf(_duration)).send();

        }

    public Farminginvestment getContract (String contractAddress, Launcher.USERS username) throws Exception {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentials = getCredentials(username);

        // Deploy the contract in the blockchain
        return Farminginvestment.load(contractAddress, web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);

    }

    private Credentials getCredentials(Launcher.USERS username) throws IOException, CipherException {

        User user;

        switch (username){
            case Farmer:
                user = FARMER;
                break;
            case Investor1:
                user = INVESTOR_1;
                break;
            case Investor2:
                user = INVESTOR_2;
                break;
            case Client:
                user = CLIENT;
                break;
            case Cowbreeder:
                user = COWBREEDER;
                break;
            default:
                user = new User();
        };


        return WalletUtils.loadCredentials(user.account_pwd, user.location_source_account);
    }
}


