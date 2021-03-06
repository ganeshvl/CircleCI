/*
 * Copyright (c) 2017. Ganesh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rrp.circleci.ui.section;

import android.support.annotation.NonNull;

import com.rrp.circleci.api.data.SectionVO;
import com.rrp.circleci.ui.AbsPresenter;

import java.util.List;

public class SectionPresenter extends AbsPresenter<SectionContract.View> implements SectionContract.Actions {

    private final List<SectionVO> mEntries;
    private final int mInitialPosition;

    public SectionPresenter(@NonNull List<SectionVO> entries, int initialPosition) {
        mEntries = entries;
        mInitialPosition = initialPosition;
    }

    @Override
    public void attachView(@NonNull SectionContract.View view) {
        super.attachView(view);
        mView.showItems(mEntries, mInitialPosition);
    }

    @Override
    public void closeClick() {
        mView.close();
    }

}
