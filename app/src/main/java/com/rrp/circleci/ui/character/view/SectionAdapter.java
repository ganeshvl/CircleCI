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

package com.rrp.circleci.ui.character.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rrp.circleci.BR;
import com.rrp.circleci.R;
import com.rrp.circleci.api.data.SectionVO;
import com.rrp.circleci.ui.adapter.ArrayAdapter;

public class SectionAdapter extends ArrayAdapter<SectionVO, SectionAdapter.ViewHolder> {

    private final String mImageTransitionName;
    private final int mType;

    public SectionAdapter(Context context, @SectionVO.Type int type, OnItemClickListener listener) {
        super(listener);
        mImageTransitionName = context.getString(R.string.transition_section_image);
        mType = type;
    }

    @SectionVO.Type
    public int getType() {
        return mType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_list_section, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mBinding.setVariable(BR.section, getItem(position));
        holder.mBinding.setVariable(BR.imageTransition, mImageTransitionName + mType + position);
        holder.mBinding.executePendingBindings();
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    public class ViewHolder extends ArrayAdapter.ViewHolder {
        public ViewHolder(ViewDataBinding binding) {
            super(binding);
        }
    }

}
