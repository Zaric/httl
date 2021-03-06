/*
 * Copyright 2011-2013 HTTL Team.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package httl.ast;

import httl.Visitor;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

/**
 * BinaryOperator. (SPI, Prototype, ThreadSafe)
 * 
 * @author Liang Fei (liangfei0201 AT gmail DOT com)
 */
public class BinaryOperator extends Operator {

	private Expression leftParameter;
	
	private Expression rightParameter;
	
	public BinaryOperator(String name, int priority, int offset){
		super(name, priority, offset);
	}

	public void accept(Visitor visitor) throws ParseException {
		leftParameter.accept(visitor);
		rightParameter.accept(visitor);
		visitor.visit(this);
	}

	public Expression getLeftParameter() {
		return leftParameter;
	}

	public void setLeftParameter(Expression leftParameter) {
		if (this.leftParameter != null)
			throw new IllegalStateException("Can not modify left parameter.");
		this.leftParameter = leftParameter;
	}

	public Expression getRightParameter() {
		return rightParameter;
	}

	public void setRightParameter(Expression rightParameter) {
		if (this.rightParameter != null)
			throw new IllegalStateException("Can not modify right parameter.");
		this.rightParameter = rightParameter;
	}

	public List<Expression> getChildren() {
		return Arrays.asList(leftParameter, rightParameter);
	}

}
