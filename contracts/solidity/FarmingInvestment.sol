pragma solidity ^0.4.0.26;

contract mortal {
    address farmer;
    function mortal() public { farmer = msg.sender; }
    function kill() public { if (msg.sender == farmer) selfdestruct(farmer); }
    
    //console.log
    event LogUint(string, uint);
    function log(string memory s , uint x) public {
       LogUint(s, x);
    }
    
    event LogInt(string, int);
    function log(string memory s , int x) public {
        LogInt(s, x);
    }
    
    event LogBytes(string, bytes);
    function log(string memory s , bytes x) public {
        LogBytes(s, x);
    }
    
    event LogBytes32(string, bytes32);
    function log(string memory s , bytes32 x) public {
        LogBytes32(s, x);
    }

    event LogAddress(string, address);
    function log(string memory s , address x) public {
        LogAddress(s, x);
    }

    event LogBool(string, bool);
    function log(string memory s , bool x) public {
        LogBool(s, x);
    }
}

contract farminginvestment is mortal {

    struct Investor{
        uint investedAmount;
        address id;
    }

    address cowBreeder;

    Investor[] investors;
    uint nbInvestors;

    uint milkPrice;

    uint collectedAmount;
    uint goalAmount;
    uint limitDate;
    bool cowsBought;

    function farminginvestment(address  _cowBreeder, uint _goalAmount, uint _milkPrice, uint duration) public{
        farmer = msg.sender;

        cowBreeder = _cowBreeder;
        milkPrice = _milkPrice;
        collectedAmount = 0;
        goalAmount = _goalAmount;
        limitDate = now + duration;
        nbInvestors = 0;

        cowsBought = false;

    }

    function invest() public payable {
        // No arguments are necessary, all
        // information is already part of
        // the transaction. The keyword payable
        // is required for the function to
        // be able to receive Ether.

        // Revert the call if the investement period is over.
        if(now <= limitDate){
            log("Investement period already ended.", true);
        }
    
        uint _investedAmount = msg.value;
        log("investedAmount: ", _investedAmount);
    
        // Vérifications que la somme ne dépasse pas le goal
        if(collectedAmount + _investedAmount <= goalAmount){
            log("Contract over invested.", true);
        }

        // Si tout va bien jusque la, on accepte l'investisseur donc creation de l'investisseur
        investors.push(Investor({investedAmount:_investedAmount, id:msg.sender}));

        // On met à jour les params
        nbInvestors = nbInvestors + 1;
        collectedAmount = collectedAmount + _investedAmount;
        log("collectedAmmount: ", collectedAmount);

        // End ?
        if(collectedAmount == goalAmount){
            investmentPeriodEnd();
            log("reached goal: ", collectedAmount);
        }
    }

    function investmentPeriodEnd () internal {
        if(collectedAmount == goalAmount){
             log("Goal amount of money has not yet been collected", true);
        }

        if(!cowBreeder.send(goalAmount)){
            throw;
        }else{
        cowsBought = true;
        log("cows bought: ", cowsBought);
        }
    }

    function buyMilk (uint quantity) public payable {
        if(msg.value == milkPrice * quantity){
            log("Not the right amount of money to buy that quantity of milk.", true);
        }

        if (cowsBought = true){
            log("Cows have not been bought yet", true);
        }

        //envoyer une partie au fermier
        if(!farmer.send(msg.value / 2)){
            throw;
        }else{
        log("farmer: ", msg.value/2);
        }

        // et une partie aux investors
        for (uint i = 0; i < nbInvestors; i++){
            //potentiellement problème d'approximation du calcul de la share?
            uint part = (((investors[i].investedAmount*10000 / goalAmount)*msg.value/2)/10000);
            if(!investors[i].id.send(part)){
                throw;
            }else{
            log("return on investment: ", part);
            }
        }
    }
}
