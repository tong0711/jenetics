/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
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
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.util;

import javolution.lang.Immutable;

/**
 * Immutable, ordered, fixed sized sequence.
 *
 * @see MSeq
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 1.0 &mdash; <em>$Date: 2013-08-29 $</em>
 */
public interface ISeq<T>
	extends
		Seq<T>,
		Copyable<MSeq<T>>,
		Immutable
{

	@Override
	public ISeq<T> subSeq(final int start, final int end);

	@Override
	public ISeq<T> subSeq(final int start);

	@Override
	public <B> ISeq<B> map(final Function<? super T, ? extends B> mapper);

	/**
	 * <p>
	 * Helper method for up-casting an given immutable sequence. This allows you
	 * to assign this sequence to an sequence where the element type is a super
	 * type of {@code T}.
	 * </p>
	 * [code]
	 * ISeq<Double> da = new Array<Double>(0.0, 1.0, 2.0).toISeq();
	 * ISeq<Number> na = da.upcast(da);
	 * ISeq<Object> oa = na.upcast(na);
	 * [/code]
	 *
	 * @param seq the sequence to cast.
	 * @return the up-casted sequence.
	 *
	 * @deprecated Will be removed in the next version.
	 */
	@Deprecated
	public <A> ISeq<A> upcast(final ISeq<? extends A> seq);

	/**
	 * Return a shallow copy of this sequence. The sequence elements are not
	 * cloned.
	 *
	 * @return a shallow copy of this sequence.
	 */
	@Override
	public MSeq<T> copy();

}





