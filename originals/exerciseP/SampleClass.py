class SampleClass() :
    def setState(self, state) :
        self.state = state
        return
        
    def getState(self) :
        return self.state

    def saveThenReturnOneMore(self, state) :
        self.state = state +1
        return self.state
        
    def saveThenReturnOneLess(self, state) :
        self.state = state - 1
        return self.state
        
