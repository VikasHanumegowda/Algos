import json


# Implement the class below, keeping the constructor's signature unchanged; it should take no arguments.

class MarkingPositionMonitor:
    dict_for_inst = {}

    def __init__(self):
        pass

    '''
        dict_for_inst = {
            "symbol" : {
                position : 0, 
                orders: {
                "order_id" : [messages],
                "order_id" : [messages],
                "order_id" : [messages]
                }
            }
        }
        
        
        message = {
            "type": "NEW",
            "symbol": "MSFT",
            "order_id": 5,
            "side": "SELL",
            "quantity": 1100,
            "time": "2016-12-22T12:07:04.521073"
        }
        
        from the question
        {
            "type": "NEW",
            "symbol": "MSFT",
            "order_id": 5,
            "side": "SELL",
            "quantity": 1100,
            "time": "2016-12-22T12:07:04.521073"
        }
        
        AAPL, IBM, MSFT
        
        
        NEW, 				out
        ORDER_ACK,
        ORDER_REJECT
        CANCEL, 			out
        CANCEL_ACK,
        CANCEL_REJECT,
        FILL
        
        
        buying - getting
        selling - giving 
        position - shares of instumenet I own
        flat - long - short
        
        return marking position		
    '''

    def on_event(self, message):
        message = json.loads(message)
        typ = message["type"]
        oid = str(message["order_id"])

        if typ == "NEW":
            sym = message["symbol"]
            if sym not in self.dict_for_inst:
                self.dict_for_inst[sym] = [0, {}]  # position, message list
            syd = message["side"]
            qty = message["quantity"]
            if syd == "SELL":
                self.dict_for_inst[sym][0] -= qty
                if len(self.dict_for_inst[sym][1][oid]) == 0:
                    self.dict_for_inst[sym][1][oid] = [message]
                else:
                    self.dict_for_inst[sym][1][oid].append(message)
            if syd == "BUY":
                if len(self.dict_for_inst[sym][1][oid]) == 0:
                    self.dict_for_inst[sym][1][oid] = [message]
                else:
                    self.dict_for_inst[sym][1][oid].append(message)

        if typ == "ORDER_ACK":
            pass
            # self.dict_for_inst[sym][1][oid].append(message)

        if typ == "ORDER_REJECT":
            if self.dict_for_inst[sym][1][oid][-1]["side"] == "SELL" and self.dict_for_inst[sym][1][oid][-1][
                "order_id"] == oid:
                self.dict_for_inst[sym][0] += self.dict_for_inst[sym][1][oid].pop()["quantity"]
                del (self.dict_for_inst[sym][1][oid])
            if self.dict_for_inst[sym][1][oid][-1]["side"] == "BUY":
                del (self.dict_for_inst[sym][1][oid])

        if typ == "CANCEL":
            self.dict_for_inst[sym][1][oid].append(message)

        if typ == "CANCEL_ACK":
            if self.dict_for_inst[sym][1][oid][-1]["type"] == "CANCEL":# and any[x["type"] == "NEW" for x in self.dict_for_inst[sym][1][oid]]:
                self.dict_for_inst[sym][0] += self.dict_for_inst[sym][1][oid].pop()["quantity"]
                del (self.dict_for_inst[sym][1][oid])

        '''
                dict_for_inst = {
                    "symbol" : [
                        position, {
                        "order_id" : [messages],
                        "order_id" : [messages],
                        "order_id" : [messages]
                        }
                    ]
                }


                message = {
                    "type": "NEW",
                    "symbol": "MSFT",
                    "order_id": 5,
                    "side": "SELL",
                    "quantity": 1100,
                    "time": "2016-12-22T12:07:04.521073"
                }
        '''

        if typ == "FILL":
            for y in range(len(self.dict_for_inst)):
                for x in self.dict_for_inst[sym][1]:
                    if self.dict_for_inst[sym][1][x][-1]["side"] == "BUY":
                        self.dict_for_inst[sym][0] += int(self.dict_for_inst[sym][1][x][-1]["quantity"])
        return self.dict_for_inst[sym][0]
